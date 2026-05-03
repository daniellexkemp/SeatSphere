package com.seatsphere.SeatSphereBackend.service;

import com.seatsphere.SeatSphereBackend.model.*;
import com.seatsphere.SeatSphereBackend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired private BookingRepository bookingRepository;
    @Autowired private TicketRepository ticketRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private ShowtimeRepository showtimeRepository;

public List<Ticket> getTicketsByShowtime(Long showtimeId) {
        return ticketRepository.findByBooking_Showtime_Id(showtimeId);
    }
    // ---------------------------------------------------------
    // VERSION 1: For the UI (ViewController)
    // Handles: createBooking(Long userId, Long showtimeId, List<Long> seatIds)

//    @Transactional
//    public Booking createBooking(Long userId, Long showtimeId, List<Long> seatIds) {

        // Fetch user and showtime details
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        Showtime showtime = showtimeRepository.findById(showtimeId)
//                .orElseThrow(() -> new RuntimeException("Showtime not found"));

        // Create the booking
//        Booking booking = new Booking();
//        booking.setUser(user);
//        booking.setShowtime(showtime);

        // Process each seat and create corresponding tickets
//        double totalAmount = 0.0;
//        List<Ticket> tickets = new ArrayList<>();

//        for (Long seatId : seatIds) {

            // Check if the seat is already reserved for this showtime
//            if (ticketRepository.existsBySeatIdAndBooking_Showtime_Id(seatId, showtimeId)) {
//                            throw new RuntimeException("Seat is already reserved for this showtime!");
//                        }
                        
            // Fetch the seat details
//            Seat seat = seatRepository.findById(seatId)
//                    .orElseThrow(() -> new RuntimeException("Seat not found"));

            // commented out for now, as occupancy is managed via reservations
           /*  if (seat.isOccupied()) {
                throw new RuntimeException("Seat " + seat.getSeatNumber() + " is already occupied");
//            } */
            
//            // Create a ticket for this seat
//            Ticket ticket = new Ticket();
//            ticket.setBooking(booking);
//            ticket.setQrCodeData("TKT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
//            ticket.setSeat(seat);
//            tickets.add(ticket);

            // Mark seat as occupied
            // seat.setOccupied(true);
            // seatRepository.save(seat);

            // Add the price of the movie to the total amount
//            totalAmount += showtime.getMovie().getPrice();
//        }
//
//        // Save the booking with its tickets and total amount
//        booking.setTickets(tickets);
//        booking.setTotalAmount(totalAmount);

//     return bookingRepository.save(booking);
//   }
        // ---------------------------------------------------------

    // ---------------------------------------------------------
    // VERSION 2: For the API (BookingController)
    // Handles: createBooking(Booking)
    // ---------------------------------------------------------
@Transactional
    public Booking createBooking(Booking booking) {
        // 1. Fix user_id: Fetch the real User from the DB
        if (booking.getUser() != null && booking.getUser().getId() != null) {
            // Registered User Flow
            User user = userRepository.findById(booking.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            booking.setUser(user);
        } else {
            // Guest Flow: Explicitly set to null so MySQL can handle it
            booking.setUser(null);
        }

        // 2. Fix showtime_id: Fetch the real Showtime from the DB
        if (booking.getShowtime() != null && booking.getShowtime().getId() != null) {
            Showtime showtime = showtimeRepository.findById(booking.getShowtime().getId())
                    .orElseThrow(() -> new RuntimeException("Showtime not found"));
            booking.setShowtime(showtime);
            
            // 3. Fix seat_row and seat_number for each ticket
            if (booking.getTickets() != null) {
                for (Ticket ticket : booking.getTickets()) {
                    ticket.setBooking(booking);

                    // Split "B-1" into Row: B and Number: 1
                    if (ticket.getSeatLabel() != null && ticket.getSeatLabel().contains("-")) {
                        String[] parts = ticket.getSeatLabel().split("-");
                        ticket.setSeatRow(parts[0]); 
                        ticket.setSeatNumber(Integer.parseInt(parts[1])); 
                    }

                    if (ticket.getQrCodeData() == null) {
                        ticket.setQrCodeData("HS-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
                    }
                }
            }
        }

        // Saves the booking and its cascading tickets with the totalAmount from the JSON
        return bookingRepository.save(booking);
    }

    // ---------------------------------------------------------
    // Helper Methods
    // ---------------------------------------------------------

    public List<Ticket> getTicketsByBookingId(Long bookingId) {
        return ticketRepository.findByBookingId(bookingId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Booking getBookingWithDetails(Long id) {
        return bookingRepository.findById(id).map(booking -> {
            // Forces fetch of movie title if lazy loaded
            if (booking.getShowtime() != null && booking.getShowtime().getMovie() != null) {
                booking.getShowtime().getMovie().getTitle();
            }
            return booking;
        }).orElse(null);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findBookingWithShowtimeAndHall(id);
    }

    // ---------------------------------------------------------
    // Deletion Method
    // ---------------------------------------------------------

    // Inside BookingService.java

@Transactional
public void deleteBooking(Long id) {
    // 1. Check if the booking exists in MySQL
    if (!bookingRepository.existsById(id)) {
        throw new RuntimeException("Booking not found with id: " + id);
    }
    
    // 2. Perform the delete. 
    // CascadeType.ALL in your Booking model will automatically wipe the related tickets.
    bookingRepository.deleteById(id);
}
}
