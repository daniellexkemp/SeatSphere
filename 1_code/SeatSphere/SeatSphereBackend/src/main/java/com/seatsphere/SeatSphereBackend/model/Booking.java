package com.seatsphere.SeatSphereBackend.model;

import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;

/**
 * Manages the transaction details when a User reserves seats for a Showtime.
 * It calculates the totalAmount, handles payment status, and links the Customer
 * to their chosen screening. Acts as the parent for individual Ticket generation.
 *
 * @author Danielle Kemp
 * @version 8.1
 * @since 2026-05-01
 */

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A booking can be made by a registered user or as a guest (null user)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = true) // Set nullable to true
    private User user;

    private double totalAmount;

    //Stores when the booking happend
    @Column(name = "booking_date", nullable = false, updatable = false)
    private LocalDateTime bookingDate;

    // One Booking -> Many Tickets
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
@JsonManagedReference
private List<Ticket> tickets = new ArrayList<>();

    // Each Booking is for one specific Showtime
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    // Default constructor for JPA
    public Booking() {}

    // Constructor for creating a booking with a user
    @PrePersist
    protected void onCreate() {
        this.bookingDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Showtime getShowtime() { return showtime; }
    public void setShowtime(Showtime showtime) { this.showtime = showtime; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    
    public List<Ticket> getTickets() { return tickets; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }

    public LocalDateTime getBookingDate() { return bookingDate; }
}

