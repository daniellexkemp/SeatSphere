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

    const movieDisplay = document.getElementById('movie-name-display');

    if (movieDisplay && movieTitle) movieDisplay.innerText = decodeURIComponent(movieTitle);
    
    // Note: Time and Date are now handled by renderSeats() to ensure 
    // they come directly from the MySQL database source of truth.
}

// -------------- SEAT RENDERING (THEATER STYLE) -------------------------
async function renderSeats() {
    const seatMap = document.getElementById('seat-map');
    if (!seatMap) return;

    const params = new URLSearchParams(window.location.search);
    const showtimeId = params.get('showtimeId'); 

    if (!showtimeId) {
        seatMap.innerHTML = `<p class="text-danger small">Error: No Showtime ID found in URL.</p>`;
        return;
    }

    seatMap.style.display = 'block'; 

    try {
        // --- FETCH SHOWTIME DETAILS, SEATS, AND RESERVED TICKETS ---
        const [showtimeResponse, seatsResponse, reservedResponse] = await Promise.all([
            fetch(`http://localhost:8080/api/showtimes/${showtimeId}`),
            fetch(`http://localhost:8080/api/seats/showtime/${showtimeId}`),
            fetch(`http://localhost:8080/api/bookings/tickets/reserved/${showtimeId}`)
        ]);

        const showtimeData = await showtimeResponse.json();
        const seats = await seatsResponse.json();
        const reservedTickets = await reservedResponse.json();

        // --- FIXTURE: DATE & TIME FROM MYSQL ---
        if (showtimeData && showtimeData.startTime) {
            const dbDate = new Date(showtimeData.startTime);
            
            // Format Date: Monday, May 4
            const dateStr = dbDate.toLocaleDateString('en-US', { 
                weekday: 'long', 
                month: 'long', 
                day: 'numeric' 
            });

            // Format Time: 7:30 PM
            const timeStr = dbDate.toLocaleTimeString('en-US', { 
                hour: 'numeric', 
                minute: '2-digit', 
                hour12: true 
            });

            const dateDisplay = document.getElementById('date-display');
            const timeDisplay = document.getElementById('time-display');

            if (dateDisplay) dateDisplay.innerText = dateStr;
            if (timeDisplay) timeDisplay.innerText = timeStr;
        }

        // --- MAP THE RESERVED LABELS FOR EASY LOOKUP ---
        const reservedLabels = reservedTickets.map(t => t.seatLabel);

        if (!seats || seats.length === 0) {
            seatMap.innerHTML = `<p class="text-muted small">This hall has no seats assigned.</p>`;
            return;
        }

        seatMap.innerHTML = ''; 

        // Group seats by Row (A, B, C, etc.)
        const rows = {};
        seats.forEach(seat => {
            const rowLabel = seat.seatRow;
            if (!rows[rowLabel]) rows[rowLabel] = [];
            rows[rowLabel].push(seat);
        });
        
        // Sort rows alphabetically and seats numerically
        Object.keys(rows).sort().forEach(rowKey => {
            const rowDiv = document.createElement('div');
            rowDiv.classList.add('d-flex', 'justify-content-center', 'gap-2', 'mb-2');
            
            rows[rowKey].sort((a, b) => a.seatNumber - b.seatNumber).forEach(seat => {
                const seatBtn = document.createElement('button');
                seatBtn.classList.add('seat');

                const seatLabel = `${seat.seatRow}-${seat.seatNumber}`;
                
                seatBtn.dataset.row = seat.seatRow;
                seatBtn.dataset.number = seat.seatNumber;
                
                if (seat.handicap) {
                    seatBtn.innerHTML = `<i class="bi bi-person-wheelchair"></i> ${seatLabel}`;
                    seatBtn.title = "Handicap Accessible"; 
                    seatBtn.classList.add('handicap-accessible');
                } else {
                    seatBtn.innerText = seatLabel;
                }
                
                if (reservedLabels.includes(seatLabel)) { 
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
        seatMap.innerHTML = `<p class="text-danger small">Backend Offline or Endpoint Error.</p>`;
    }
}

// -------------- UI UPDATES -------------------------
function updateBookingInfo() {
    const params = new URLSearchParams(window.location.search);
    const moviePrice = parseFloat(params.get('price')) || 10.00; 

    const selected = document.querySelectorAll('.seat.selected').length;
    const countDisplay = document.getElementById('selected-count');
    const priceDisplay = document.getElementById('total-price');

    if (countDisplay) countDisplay.innerText = selected;
    if (priceDisplay) priceDisplay.innerText = `$${(selected * moviePrice).toFixed(2)}`;
}

// -------------- NAVIGATION LOGIC -------------------------
function handleBooking() {
    const selectedSeats = document.querySelectorAll('.seat.selected');
    const params = new URLSearchParams(window.location.search);
    
    if (selectedSeats.length === 0) {
        alert("Please select a seat first!");
        return;
    }

    const showtimeId = params.get('showtimeId');
    
    const seatData = Array.from(selectedSeats).map(s => 
        `${s.dataset.row}-${s.dataset.number}`
    ).join(',');
    
    // Use decodeURIComponent and encodeURIComponent to ensure clean URL transfer
    const queryParams = new URLSearchParams({
        showtimeId: showtimeId,
        movie: document.getElementById('movie-name-display')?.innerText || "Movie",
        time: document.getElementById('time-display')?.innerText || "Time",
        date: document.getElementById('date-display')?.innerText || "Date",
        seats: seatData,
        price: params.get('price') || "10.00"
    });

    window.location.href = `checkout.html?${queryParams.toString()}`;
}
