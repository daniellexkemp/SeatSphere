package com.seatsphere.SeatSphereBackend.controller;

import com.seatsphere.SeatSphereBackend.model.Seat;
import com.seatsphere.SeatSphereBackend.repository.SeatRepository; // You'll need this interface
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin(origins = "http://localhost:3000")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping
    public List<Seat> getSeats(@RequestParam(required = false) Long hallId) {
        if (hallId != null) {
            return seatRepository.findByTheaterHallId(hallId);
        }
        return seatRepository.findAll();
    }
}