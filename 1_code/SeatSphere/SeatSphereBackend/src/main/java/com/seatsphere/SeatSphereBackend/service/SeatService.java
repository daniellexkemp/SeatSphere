package com.seatsphere.SeatSphereBackend.service;

import com.seatsphere.SeatSphereBackend.model.*;
import com.seatsphere.SeatSphereBackend.repository.SeatRepository;
import com.seatsphere.SeatSphereBackend.repository.ShowtimeRepository;
import com.seatsphere.SeatSphereBackend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired 
    private SeatRepository seatRepository;

    @Autowired 
    private TicketRepository ticketRepository;

    @Autowired 
    private ShowtimeRepository showtimeRepository;

    /**
     * This is the core method for the frontend seat map.
     * it maps physical seats to a ResponseDTO that includes real-time occupancy.
     */
    public List<SeatResponseDTO> getSeatsForShowtime(Long showtimeId) {
        // 1. Find the showtime to identify the correct Theater Hall
        Showtime showtime = showtimeRepository.findById(showtimeId)
                .orElseThrow(() -> new RuntimeException("Showtime not found with id: " + showtimeId));

        // 2. Get all physical seats assigned to that Hall
        // Note: Ensure your Showtime model has a getTheaterHall() method
        List<Seat> physicalSeats = seatRepository.findByTheaterHallId(showtime.getTheaterHall().getId());

        // 3. Convert each Seat into a SeatResponseDTO and check if it is already booked
        return physicalSeats.stream().map(seat -> {
            boolean occupied = ticketRepository.existsBySeatRowAndSeatNumberAndBooking_Showtime_Id(
                    seat.getSeatRow(), 
                    seat.getSeatNumber(), 
                    showtimeId
            );
            return new SeatResponseDTO(seat, occupied);
        }).collect(Collectors.toList());
    }

    // Fetch all seats for the Admin/Manager view
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    // Fetch physical seats for a specific hall (Used by Hall Management)
    public List<Seat> getSeatsByHall(Long hallId) {
        return seatRepository.findByTheaterHallId(hallId);
    }

    // Save or update a seat (Used by Staff to add new seats or change handicap status)
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }

    public Seat getSeatById(Long id) {
        return seatRepository.findById(id).orElse(null);
    }
}
