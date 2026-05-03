package com.seatsphere.SeatSphereBackend.controller;

import com.seatsphere.SeatSphereBackend.model.Movie;
import com.seatsphere.SeatSphereBackend.model.Showtime;
import com.seatsphere.SeatSphereBackend.model.TheaterHall;
import com.seatsphere.SeatSphereBackend.service.MovieService;
import com.seatsphere.SeatSphereBackend.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theater")
@CrossOrigin(origins = "http://localhost:3000")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private MovieService movieService;

    // Add a new Movie: POST http://localhost:8080/api/theater/movies
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie); // Use the method name from your MovieService
    }
    
    // Get all Movies: GET http://localhost:8080/api/theater/movies
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Add a new Hall: POST http://localhost:8080/api/theater/halls
    @PostMapping("/halls")
    public TheaterHall addHall(@RequestBody TheaterHall hall) {
        return theaterService.addHall(hall);
    }

    // Get all Halls: GET http://localhost:8080/api/theater/halls
    @GetMapping("/halls")
    public List<TheaterHall> getAllHalls() {
        return theaterService.getAllHalls();
    }

    // Assign a Movie to a Hall (Schedule a Showtime)
    // POST http://localhost:8080/api/theater/showtimes
    @PostMapping("/showtimes")
    public Showtime addShowtime(@RequestBody Showtime showtime) {
        return theaterService.scheduleShowtime(showtime);
    }

    // Get the schedule
    // GET http://localhost:8080/api/theater/showtimes
    @GetMapping("/showtimes")
    public List<Showtime> getAllShowtimes() {
        return theaterService.getAllShowtimes();
    }
}
