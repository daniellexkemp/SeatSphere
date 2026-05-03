/* ----------------------------------------------------------------------
   MAIN JAVASCRIPT - SeatSphere (Node.js + Java Integration) - script.js
   ----------------------------------------------------------------------*/

document.addEventListener('DOMContentLoaded', function() {
    
    if (document.getElementById('movie-grid')) {
        loadMovies();
    }
    initLogin();
});

function updateDate(element, selectedDate) {
    //  Handle the Visuals: Remove 'active' from all, add to clicked one
    document.querySelectorAll('.date-tab').forEach(tab => tab.classList.remove('active'));
    element.classList.add('active');

    // Handle the Logic: Reload the movies for the chosen day
    loadMovies(selectedDate);
}


async function loadMovies(filterDate = "2026-05-04") {
    const grid = document.getElementById('movie-grid');
    if (!grid) return;

    try {
        const response = await fetch('http://localhost:8080/api/movies');
        if (!response.ok) throw new Error('Network response was not ok');
        
        const movies = await response.json();

        grid.innerHTML = movies.map(movie => {
            const allShowtimes = movie.showtimes || [];

            // Sort showtimes by start time
            allShowtimes.sort((a, b) => new Date(a.startTime) - new Date(b.startTime));

            // USE THE filterDate PARAMETER HERE instead of hardcoding
            const todaysShows = allShowtimes.filter(st => st.startTime.startsWith(filterDate));

            // Minimalist Approach: Don't show the card if no shows exist for this specific day
            if (todaysShows.length === 0) return '';

            return `
                <div class="movie-card"> 
                    <div class="movie-poster-box">
                        <img src="${movie.imagePath || 'https://via.placeholder.com/350x500'}" alt="${movie.title}">
                    </div>
                    <div class="movie-title">${movie.title.toLowerCase()}</div>
                    <div class="showtime-container">
                        ${todaysShows.map(st => `
                                <a href="/seats.html?showtimeId=${st.id}&movie=${encodeURIComponent(movie.title)}&time=${formatTime(st.startTime)}&price=${movie.price}" 
                                    class="showtime-btn">
                                    ${formatTime(st.startTime)}
                                </a>
                            `).join('') 
                        }
                    </div>
                </div>`;
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
