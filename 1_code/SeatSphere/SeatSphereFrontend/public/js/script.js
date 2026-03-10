/* ----------------------------------------------------------------------
   MAIN JAVASCRIPT - SeatSphere (Node.js + Java Integration) - script.js
   ----------------------------------------------------------------------*/

document.addEventListener('DOMContentLoaded', function() {
    if (document.getElementById('movie-grid')) {
        loadMovies();
    }
    initLogin();
});

async function loadMovies() {
    const grid = document.getElementById('movie-grid');
    if (!grid) return;

    try {
        const response = await fetch('http://localhost:8080/api/movies');
        if (!response.ok) throw new Error('Network response was not ok');
        
        const movies = await response.json();
        console.log("Movies with showtimes:", movies); // See the data in F12

        grid.innerHTML = movies.map(movie => {
            // Since we fixed the Java, showtimes are now INSIDE the movie object!
            const movieShowtimes = movie.showtimes || [];

            return `
                <div class="movie-card"> 
                    <div class="movie-poster-box">
                        <img src="${movie.imagePath || 'https://via.placeholder.com/350x500'}" alt="${movie.title}">
                    </div>
                    <div class="movie-title">${movie.title.toLowerCase()}</div>
                    <div class="movie-meta">${movie.duration} min | ${movie.rating || 'PG-13'}</div>
                    <div class="showtime-container">
                        ${movieShowtimes.length > 0 ? 
                            movieShowtimes.map(st => `
                                <a href="/seats.html?showtimeId=${st.id}&movie=${encodeURIComponent(movie.title)}&time=${formatTime(st.startTime)}" 
                                   class="showtime-btn">
                                   ${formatTime(st.startTime)}
                                </a>
                            `).join('') 
                            : '<span class="text-muted small">No shows today</span>'
                        }
                    </div>
                </div>
            `;
        }).join('');
    } catch (error) {
        console.error("Connection Error:", error);
        grid.innerHTML = `<p class="text-danger">Backend Offline. Check Spring Boot.</p>`;
    }
}

function formatTime(t) {
    if (!t) return "N/A";
    const date = new Date(t);
    return date.toLocaleTimeString([], { hour: 'numeric', minute: '2-digit', hour12: true }).toLowerCase();
}

// Window functions for scrolling
window.scrollGrid = function(direction) {
    const grid = document.getElementById('movie-grid');
    if (grid) {
        grid.scrollBy({ left: direction * 400, behavior: 'smooth' });
    }
};

function updateTheatre(name) {
    const display = document.getElementById('current-theatre');
    if (display) display.innerHTML = `${name} <i class="bi bi-geo-alt-fill"></i>`;
}

function initLogin() {
    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', async (e) => {
            e.preventDefault();
            const loginData = {
                username: document.getElementById('username').value,
                password: document.getElementById('password').value
            };
            try {
                const response = await fetch('http://localhost:8080/api/users/login', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(loginData)
                });
                if (response.ok) {
                    const user = await response.json();
                    alert("Welcome back, " + user.firstName + "!");
                    window.location.href = "/"; 
                } else {
                    alert("Invalid credentials.");
                }
            } catch (error) {
                alert("Error: Backend server is not responding.");
            }
        });
    }
}