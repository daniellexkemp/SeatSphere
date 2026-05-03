const express = require('express');
const path = require('path');
const app = express();

const fetch = require('node-fetch'); // npm install node-fetch@2

// New route to fetch all bookings (for dashboard)
app.get('/api/bookings', async (req, res) => {
    try {
        const response = await fetch('http://localhost:8080/api/bookings');
        const data = await response.json();
        res.json(data);
    } catch (err) {
        res.status(500).json({ error: 'Backend not reachable' });
    }
});

// Port 3000 is standard for Node.js development
const PORT = 3000;

// This line is CRUCIAL. It tells Node that all your HTML, CSS, JS, 
// and Images are inside the 'public' folder.
app.use(express.static(path.join(__dirname, 'public')));

// ROUTE: When you go to http://localhost:3000/
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// ROUTE: When you go to http://localhost:3000/login
app.get('/login', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'login.html'));
});

// ROUTE: My Bookings / Dashboard page
app.get('/my-bookings', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'dashboard.html'));
});

// ROUTE: Movie Selection Page
app.listen(PORT, () => {
    console.log(`====================================================`);
    console.log(`SeatSphere Frontend is running at: http://localhost:3000`);
    console.log(`Make sure your Java Backend is running on port 8080!`);
    console.log(`====================================================`);
});

// NEW ROUTE: Delete a booking by ID
app.delete('/api/bookings/:id', async (req, res) => {
    try {
        const bookingId = req.params.id;
        const response = await fetch(`http://localhost:8080/api/bookings/${bookingId}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            res.status(200).send({ message: 'Deleted successfully' });
        } else {
            res.status(response.status).json({ error: 'Backend failed to delete' });
        }
    } catch (err) {
        console.error("Proxy Error:", err);
        res.status(500).json({ error: 'Proxy could not reach Java backend' });
    }
});
