package com.seatsphere.SeatSphereBackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class ViewController {

    // Simply serves the home page
    @GetMapping("/")
    public String showHomePage() {
        return "index"; 
    }

    // Serves the seat selection page
    @GetMapping("/booking/{id}")
    public String showBookingPage() {
        return "booking"; 
    }

    // Serves the tickets/dashboard page
    @GetMapping("/my-bookings")
    public String showMyBookings() {
        return "database"; // This points to database.html
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}