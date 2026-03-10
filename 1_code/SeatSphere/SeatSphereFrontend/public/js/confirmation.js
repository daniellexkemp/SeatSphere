/* -----------------------------------------------------------
   CONFIRMATION JAVASCRIPT - Ticket Generation - confirmation.js
   ----------------------------------------------------------- */

document.addEventListener('DOMContentLoaded', () => {
    // Grab data from the URL passed by checkout.js
    const params = new URLSearchParams(window.location.search);
    
    const movieName = params.get('movie') || 'The Greatest Showman';
    const showTime = params.get('time') || '10:00 AM';
    const seatSelection = params.get('seats') || 'A1, A2';
    const pricePaid = params.get('total') || '10.06';
    const dbBookingId = params.get('bookingId'); 

    // Create a "Live" Date for the ticket
    const today = new Date().toLocaleDateString('en-US', { 
        weekday: 'long', 
        year: 'numeric', 
        month: 'long', 
        day: 'numeric' 
    });

    // Update the UI Elements
    if(document.getElementById('movie-title')) 
        document.getElementById('movie-title').innerText = decodeURIComponent(movieName);
    
    if(document.getElementById('display-time')) 
        document.getElementById('display-time').innerText = showTime;
    
    if(document.getElementById('seats-list')) 
        document.getElementById('seats-list').innerText = seatSelection;
    
    if(document.getElementById('total-price')) {
        // Ensure there is a dollar sign
        document.getElementById('total-price').innerText = pricePaid.includes('$') ? pricePaid : `$${pricePaid}`;
    }
    
    if(document.getElementById('book-date')) 
        document.getElementById('book-date').innerText = today;

    // Use the Database ID (or a random one if DB fails)
    const finalBookingID = dbBookingId ? `HS-${dbBookingId}` : "HS-" + Math.random().toString(36).substr(2, 8).toUpperCase();

    if(document.getElementById('booking-id')) 
        document.getElementById('booking-id').innerText = "#" + finalBookingID;

    // Generate QR Code using the QR Server API
    const qrImage = document.getElementById('qr-image');
    if (qrImage) {
        const qrData = encodeURIComponent(`CONFIRMED:${finalBookingID}|MOVIE:${movieName}`);
        qrImage.src = `https://api.qrserver.com/v1/create-qr-code/?size=220x220&data=${qrData}`;
    }
    
    console.log("Confirmation Page Loaded for Booking:", finalBookingID);
});