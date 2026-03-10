package com.seatsphere.SeatSphereBackend.controller;

import com.seatsphere.SeatSphereBackend.model.Showtime;
import com.seatsphere.SeatSphereBackend.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
@CrossOrigin(origins = "*") 
public class ShowtimeController {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    // This handles: http://localhost:8080/api/showtimes
    @GetMapping
    public List<Showtime> getAll() {
        System.out.println("Showtime API was hit!");
        return showtimeRepository.findAll();
    }

    // This handles: http://localhost:8080/api/showtimes/movie/1
    @GetMapping("/movie/{movieId}")
    public List<Showtime> getByMovie(@PathVariable Long movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }
}