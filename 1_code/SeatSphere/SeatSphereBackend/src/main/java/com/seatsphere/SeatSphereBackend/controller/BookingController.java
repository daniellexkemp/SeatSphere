package com.seatsphere.SeatSphereBackend.controller;

import com.seatsphere.SeatSphereBackend.model.Booking;
import com.seatsphere.SeatSphereBackend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a new booking via JSON
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        if (booking == null) {
            return ResponseEntity.badRequest().build();
        }
        Booking savedBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(savedBooking);
    }

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Get booking by ID (needed for confirmation page)
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingWithDetails(id);
        if (booking == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(booking);
    }
}