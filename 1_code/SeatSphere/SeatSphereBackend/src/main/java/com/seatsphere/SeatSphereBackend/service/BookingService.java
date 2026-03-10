package com.seatsphere.SeatSphereBackend.service;

import com.seatsphere.SeatSphereBackend.model.*;
import com.seatsphere.SeatSphereBackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired private BookingRepository bookingRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private ShowtimeRepository showtimeRepository;
    @Autowired private SeatRepository seatRepository;

    // ---------------------------------------------------------
    // VERSION 1: For the UI (ViewController)
    // Handles: createBooking(Long userId, Long showtimeId, List<Long> seatIds)
    // ---------------------------------------------------------
    @Transactional
    public Booking createBooking(Long userId, Long showtimeId, List<Long> seatIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Showtime showtime = showtimeRepository.findById(showtimeId)
                .orElseThrow(() -> new RuntimeException("Showtime not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowtime(showtime);

        double totalAmount = 0.0;
        List<Ticket> tickets = new ArrayList<>();

        for (Long seatId : seatIds) {
            Seat seat = seatRepository.findById(seatId)
                    .orElseThrow(() -> new RuntimeException("Seat not found"));

            if (seat.isOccupied()) {
                throw new RuntimeException("Seat " + seat.getSeatNumber() + " is already occupied");
            }

            Ticket ticket = new Ticket();
            ticket.setBooking(booking);
            ticket.setQrCodeData("TKT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
            ticket.setSeat(seat);

            tickets.add(ticket);

            // Mark seat as occupied
            seat.setOccupied(true);
            seatRepository.save(seat);

            totalAmount += showtime.getMovie().getPrice();
        }

        booking.setTickets(tickets);
        booking.setTotalAmount(totalAmount);

        return bookingRepository.save(booking);
    }

    // ---------------------------------------------------------
    // VERSION 2: For the API (BookingController)
    // Handles: createBooking(Booking)
    // ---------------------------------------------------------
    @Transactional
    public Booking createBooking(Booking booking) {
        if (booking.getTickets() != null) {
            double total = 0.0;
            for (Ticket ticket : booking.getTickets()) {
                ticket.setBooking(booking);

                if (ticket.getQrCodeData() == null) {
                    ticket.setQrCodeData("API-" + UUID.randomUUID().toString().substring(0, 8));
                }

                Seat seat = ticket.getSeat();
                if (seat == null) throw new RuntimeException("Seat missing on ticket");
                if (seat.isOccupied()) throw new RuntimeException("Seat already occupied");

                seat.setOccupied(true);
                seatRepository.save(seat);

                total += booking.getShowtime().getMovie().getPrice();
            }
            booking.setTotalAmount(total);
        }

        return bookingRepository.save(booking);
    }

    // ---------------------------------------------------------
    // Fetch all bookings
    // ---------------------------------------------------------
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // ---------------------------------------------------------
    // Fetch a single booking with nested details
    // ---------------------------------------------------------
    @Transactional(readOnly = true)
    public Booking getBookingWithDetails(Long id) {
        return bookingRepository.findById(id).map(booking -> {
            // Force initialization of lazy-loaded relationships
            booking.getShowtime().getMovie().getTitle();    // movie
            booking.getShowtime().getTheaterHall().getName();      // hall
            booking.getTickets().forEach(t -> t.getSeat().getSeatNumber()); // seats
            return booking;
        }).orElse(null);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findBookingWithShowtimeAndHall(id);
    }
}