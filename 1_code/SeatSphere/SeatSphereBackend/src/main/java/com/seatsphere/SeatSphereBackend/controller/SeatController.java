package com.seatsphere.SeatSphereBackend.controller;

import com.seatsphere.SeatSphereBackend.model.Seat;
import com.seatsphere.SeatSphereBackend.model.SeatResponseDTO;
import com.seatsphere.SeatSphereBackend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin(origins = "*") // Allows your Node.js frontend to talk to this API
public class SeatController {

    @Autowired
    private SeatService seatService;

    // Used by the Admin/Staff page to see all seats across all halls
    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    // CRITICAL: Used by your Seat Map to draw the theater hall
    @GetMapping("/hall/{hallId}")
    public ResponseEntity<List<Seat>> getSeatsByHall(@PathVariable Long hallId) {
        List<Seat> seats = seatService.getSeatsByHall(hallId);
        return ResponseEntity.ok(seats);
    }

    @GetMapping("/showtime/{showtimeId}")
    public ResponseEntity<List<SeatResponseDTO>> getSeatsForShowtime(@PathVariable Long showtimeId) {
        List<SeatResponseDTO> seats = seatService.getSeatsForShowtime(showtimeId);
        return ResponseEntity.ok(seats);
    }

    // Allows staff to fetch a specific seat's details (like handicap status)
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id) {
        Seat seat = seatService.getSeatById(id);
        return seat != null ? ResponseEntity.ok(seat) : ResponseEntity.notFound().build();
    }

    // Allows staff to update a seat (e.g., making a seat handicap accessible)
    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Long id, @RequestBody Seat seatDetails) {
        Seat updatedSeat = seatService.getSeatById(id);
        if (updatedSeat != null) {
            updatedSeat.setSeatRow(seatDetails.getSeatRow());
            updatedSeat.setSeatNumber(seatDetails.getSeatNumber());
            updatedSeat.setHandicap(seatDetails.isHandicap());
            return ResponseEntity.ok(seatService.saveSeat(updatedSeat));
        }
        return ResponseEntity.notFound().build();
    }
}
