package com.seatsphere.SeatSphereBackend.model;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Stores details for films available for screening in the SeatSphere/HappySeats system.
 * Includes metadata required for the UI, such as title, genre, duration, and age rating.
 * This entity serves as the catalog for all potential scheduled showtimes.
 *
 * @author Danielle Kemp
 * @version 1.1
 * @since 2026-03-08
 */

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "image_path")
    private String imagePath;
    private String genre;
    private int duration; // in minutes
    private String rating; // e.g. PG, PG-13, R
    private double price;

    // mappedBy must match the variable name 'movie' inside your Showtime.java class
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Showtime> showtimes = new ArrayList<>();

    public Movie() {}  // Default constructor required by JPA

    // ---------------- Constructors ----------------------
    public Movie(String title, String genre, int duration, String rating, double price) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.price = price;
    }

    // ------------ Getters & Setters ---------------------
    
    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}