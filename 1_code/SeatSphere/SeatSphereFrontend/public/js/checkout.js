/* -----------------------------------------------------------
   CHECKOUT JAVASCRIPT - checkout.js
   ----------------------------------------------------------- */

document.addEventListener('DOMContentLoaded', () => {
    const urlParams = new URLSearchParams(window.location.search);
    const seats = urlParams.get('seats');
    const movie = urlParams.get('movie');
    const time = urlParams.get('time');

    // Handle Price Calculations
    if (seats) {
        const seatArray = seats.split(',');
        const count = seatArray.length;
        
        const pricePerTicket = 8.00;
        const serviceFee = 1.50;
        const taxRate = 0.07; 

        const subtotal = count * pricePerTicket;
        const tax = subtotal * taxRate;
        const total = subtotal + serviceFee + tax;

        if(document.getElementById('display-seats')) document.getElementById('display-seats').innerText = seats;
        if(document.getElementById('ticket-qty')) document.getElementById('ticket-qty').innerText = count;
        if(document.getElementById('subtotal-amount')) document.getElementById('subtotal-amount').innerText = `$${subtotal.toFixed(2)}`;
        if(document.getElementById('tax-amount')) document.getElementById('tax-amount').innerText = `$${tax.toFixed(2)}`;
        if(document.getElementById('final-total')) document.getElementById('final-total').innerText = `$${total.toFixed(2)}`;
    }

    if (movie && document.getElementById('movie-title-display')) 
        document.getElementById('movie-title-display').innerText = decodeURIComponent(movie);
    if (time && document.getElementById('showtime-display')) 
        document.getElementById('showtime-display').innerText = time;
});

// Logic for the Radio Buttons
function toggleCardForm() {
    const cardForm = document.getElementById('credit-card-info');
    const addCardRadio = document.getElementById('addCard');
    if (cardForm && addCardRadio) {
        cardForm.style.display = addCardRadio.checked ? 'block' : 'none';
    }
}

// The Purchase Button Function
async function processPurchase() {
    const params = new URLSearchParams(window.location.search);
    const sId = params.get('showtimeId') || params.get('id') || "1"; 
    const seatsParam = params.get('seats') || "A1";
    const totalText = document.getElementById('final-total').innerText.replace('$', '');

    const bookingData = {
        showtime: { id: parseInt(sId) }, 
        totalAmount: parseFloat(totalText),
        tickets: seatsParam.split(',').map(seat => ({
            seatNumber: seat.trim(),
            qrCodeData: "TKT-" + Math.random().toString(36).substr(2, 6).toUpperCase()
        }))
    };

    try {
        const response = await fetch('http://localhost:8080/api/bookings', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(bookingData)
        });

        if (response.ok) {
            const saved = await response.json();
            window.location.href = `confirmation.html?bookingId=${saved.id}&movie=${params.get('movie')}&time=${params.get('time')}&seats=${seatsParam}&total=${totalText}`;
        } else {
            // Fallback for demo
            window.location.href = `confirmation.html?bookingId=DEMO&movie=${params.get('movie')}&time=${params.get('time')}&seats=${seatsParam}&total=${totalText}`;
        }
    } catch (e) {
        // Fallback for offline demo
        window.location.href = `confirmation.html?bookingId=OFFLINE&movie=${params.get('movie')}&time=${params.get('time')}&seats=${seatsParam}&total=${totalText}`;
    }
}