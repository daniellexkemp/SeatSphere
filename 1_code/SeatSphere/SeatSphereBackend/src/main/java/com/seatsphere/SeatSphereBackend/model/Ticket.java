package com.seatsphere.SeatSphereBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Represents the final digital receipt and admission pass for a customer.
 */
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qrCodeData;

    @Column(name = "seat_label")
    private String seatLabel; 

    @Column(name = "seat_row")
    private String seatRow;   // e.g., "B"

    @Column(name = "seat_number")
    private int seatNumber;   // e.g., 1


    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonBackReference
    private Booking booking;

    public Ticket() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getQrCodeData() { return qrCodeData; }
    public void setQrCodeData(String qrCodeData) { this.qrCodeData = qrCodeData; }

    public String getSeatLabel() { return seatLabel; }
    public void setSeatLabel(String seatLabel) { this.seatLabel = seatLabel; }
    
    // Updated Getters/Setters
    public String getSeatRow() { return seatRow; }
    public void setSeatRow(String seatRow) { this.seatRow = seatRow; }
    
    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
    
    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }
}
