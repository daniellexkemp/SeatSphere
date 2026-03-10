package com.seatsphere.SeatSphereBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

/**
 * Represents a physical chair in a TheaterHall identified by row and number.
 * This class is essential for generating the real-time visual seat map in HappySeats.
 * It tracks occupancy status to prevent double-bookings (REQ 2 and REQ 11).
 *
 * @author Danielle Kemp
 * @version 1.0
 * @since 2026-03-04
 */

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatRow;    // e.g., "A", "B", "C"
    private int seatNumber;    // e.g., 1, 2, 3
    
    // This tracks if the seat is physically taken
    private boolean isOccupied = false; 

    @ManyToOne
    @JoinColumn(name = "hall_id")
    @JsonIgnoreProperties("seats")
    private TheaterHall theaterHall;

    public Seat() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSeatRow() { return seatRow; }
    public void setSeatRow(String seatRow) { this.seatRow = seatRow; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public boolean isOccupied() { return isOccupied; }
    public void setOccupied(boolean occupied) { isOccupied = occupied; }

    public TheaterHall getTheaterHall() { return theaterHall; }
    public void setTheaterHall(TheaterHall theaterHall) { this.theaterHall = theaterHall; }
}
