package com.seatsphere.SeatSphereBackend.controller;

import com.seatsphere.SeatSphereBackend.model.Booking;
import com.seatsphere.SeatSphereBackend.model.Ticket;
import com.seatsphere.SeatSphereBackend.repository.TicketRepository;
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

    @Autowired 
    private TicketRepository ticketRepository;

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
    
    // New endpoint to get all reserved tickets for a specific showtime
    @GetMapping("/tickets/reserved/{showtimeId}")
    public List<Ticket> getReservedTickets(@PathVariable Long showtimeId) {
        // This calls the new method you added to the TicketRepository
        return ticketRepository.findByBooking_Showtime_Id(showtimeId);
    }

    // Get booking by ID (needed for confirmation page)
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingWithDetails(id);
        if (booking == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok().build();
    }
}
