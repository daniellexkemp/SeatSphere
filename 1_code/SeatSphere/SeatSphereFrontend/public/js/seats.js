/* -----------------------------------------------------------
   SEATS JAVASCRIPT - SeatSphere Booking Logic - seats.js
   ----------------------------------------------------------- */

document.addEventListener('DOMContentLoaded', () => {
    initHeaderInfo();
    renderSeats();

    // ATTACH NAVIGATION LISTENER
    const confirmBtn = document.getElementById('confirm-booking');
    if (confirmBtn) {
        confirmBtn.addEventListener('click', (e) => {
            e.preventDefault(); 
            handleBooking();
        });
    }
});

// -------------- HEADER SETUP -------------------------
function initHeaderInfo() {
    const params = new URLSearchParams(window.location.search);
    const movieTitle = params.get('movie');
    const showtime = params.get('time');

    const movieDisplay = document.getElementById('movie-name-display');
    const timeDisplay = document.getElementById('time-display');
    
    if (movieDisplay && movieTitle) movieDisplay.innerText = decodeURIComponent(movieTitle);
    if (timeDisplay && showtime) timeDisplay.innerText = showtime;
}

// -------------- SEAT RENDERING (THEATER STYLE) -------------------------
async function renderSeats() {
    const seatMap = document.getElementById('seat-map');
    if (!seatMap) return;

    seatMap.style.display = 'block'; 

    try {
        const response = await fetch('http://localhost:8080/api/seats');
        const seats = await response.json();

        if (!seats || seats.length === 0) {
            seatMap.innerHTML = `<p class="text-muted small">Database is empty.</p>`;
            return;
        }

        seatMap.innerHTML = ''; 

        // Group seats by Row (A, B, C, etc.)
        const rows = {};
        seats.forEach(seat => {
            const rowLabel = seat.seatRow || 'A';
            if (!rows[rowLabel]) rows[rowLabel] = [];
            rows[rowLabel].push(seat);
        });

        Object.keys(rows).sort().forEach(rowKey => {
            const rowDiv = document.createElement('div');
            rowDiv.classList.add('d-flex', 'justify-content-center', 'gap-2', 'mb-2');
            
            rows[rowKey].forEach(seat => {
                const seatBtn = document.createElement('button');
                seatBtn.classList.add('seat');
                
                // --- HANDICAP LOGIC START ---
                const seatLabel = `${rowKey}${seat.seatNumber}`;
                const isHandicap = (rowKey === 'A' && (seat.seatNumber === 1 || seat.seatNumber === 4));
                if (isHandicap) {
                    // This adds the icon and the label (e.g., ♿ A1)
                    seatBtn.innerHTML = `<i class="bi bi-person-wheelchair"></i> ${seatLabel}`;
                    seatBtn.title = "Handicap Accessible"; 
                } else {
                    seatBtn.innerText = seatLabel;
                }
                
                const isOccupied = seat.occupied || seat.isOccupied;
                if (isOccupied) { 
                    seatBtn.classList.add('reserved'); 
                    seatBtn.disabled = true; 
                } else {
                    seatBtn.classList.add('available'); 
                    seatBtn.addEventListener('click', (e) => {
                        e.preventDefault();
                        seatBtn.classList.toggle('selected');
                        updateBookingInfo();
                    });
                }
                rowDiv.appendChild(seatBtn);
            });
            seatMap.appendChild(rowDiv);
        });

    } catch (error) {
        console.error("Fetch Error:", error);
        seatMap.innerHTML = `<p class="text-danger small">Backend Offline.</p>`;
    }
}

// -------------- UI UPDATES -------------------------
function updateBookingInfo() {
    const selected = document.querySelectorAll('.seat.selected').length;
    const countDisplay = document.getElementById('selected-count');
    const priceDisplay = document.getElementById('total-price');

    if (countDisplay) countDisplay.innerText = selected;
    if (priceDisplay) priceDisplay.innerText = `$${(selected * 8.00).toFixed(2)}`;
}

// -------------- NAVIGATION LOGIC -------------------------
function handleBooking() {
    const selectedSeats = document.querySelectorAll('.seat.selected');
    
    if (selectedSeats.length === 0) {
        alert("Please select a seat first!");
        return;
    }

    // Capture current UI state
    const movieTitle = document.getElementById('movie-name-display')?.innerText || "Movie";
    const showtime = document.getElementById('time-display')?.innerText || "Time";
    const seatLabels = Array.from(selectedSeats).map(s => s.innerText);
    
    const queryParams = new URLSearchParams({
        movie: movieTitle,
        time: showtime,
        seats: seatLabels.join(',')
    });

    // Execution of the "Happy Path" redirect
    window.location.href = `checkout.html?${queryParams.toString()}`;
}