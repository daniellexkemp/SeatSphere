package com.seatsphere.SeatSphereBackend.service;

import com.seatsphere.SeatSphereBackend.model.TheaterHall;
import com.seatsphere.SeatSphereBackend.model.Showtime;
import com.seatsphere.SeatSphereBackend.repository.TheaterHallRepository;
import com.seatsphere.SeatSphereBackend.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterHallRepository theaterHallRepository;

    @Autowired
    private ShowtimeRepository showtimeRepository;

    // Hall Methods
    public TheaterHall addHall(TheaterHall hall) { 
        return theaterHallRepository.save(hall); 
    }

    public List<TheaterHall> getAllHalls() { 
        return theaterHallRepository.findAll(); 
    }

    // THE BRIDGE: Showtime Methods (Assigning Movie to Hall)
    public Showtime scheduleShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }
}