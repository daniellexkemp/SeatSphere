package com.seatsphere.SeatSphereBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Represents the final digital receipt and admission pass for a customer.
 * Contains the qrCodeData used by theater staff for entry validation (REQ 10).
 * Each ticket corresponds to a specific Seat within a confirmed Booking.
 *
 * @author Danielle Kemp
 * @version 1.0
 * @since 2026-03-04
 */

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String qrCodeData;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonBackReference
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "seat_id") // Each ticket is for one specific seat
    private Seat seat;

    public Ticket() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getQrCodeData() { return qrCodeData; }
    public void setQrCodeData(String qrCodeData) { this.qrCodeData = qrCodeData; }
    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }
    public Seat getSeat() { return seat; }
    public void setSeat(Seat seat) { this.seat = seat; }
}
