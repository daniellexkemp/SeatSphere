package com.seatsphere.SeatSphereBackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties("showtimes")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    @JsonIgnoreProperties("showtimes")
    private TheaterHall theaterHall;

    private LocalDateTime startTime;

    public Showtime() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
    public TheaterHall getTheaterHall() { return theaterHall; }
    public void setTheaterHall(TheaterHall theaterHall) { this.theaterHall = theaterHall; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
}