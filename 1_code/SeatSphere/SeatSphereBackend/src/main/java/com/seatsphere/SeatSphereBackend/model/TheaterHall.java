package com.seatsphere.SeatSphereBackend.model;

import jakarta.persistence.*;

/**
 * Defines a physical auditorium or screening room within a theater location.
 * It maintains the name and total seating capacity, serving as the physical
 * container for Showtimes and the parent entity for individual Seat objects.
 *
 * @author Danielle Kemp
 * @version 1.0
 * @since 2026-03-04
 */

@Entity
@Table(name = "theater_halls")
public class TheaterHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // e.g., "Hall 1"
    private int totalSeats;

// Default Constructor
    public TheaterHall() {}

    // Parameterized Constructor
    public TheaterHall(String name, int totalSeats, String screenType) {
        this.name = name;
        this.totalSeats = totalSeats;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

}
