package com.seatsphere.SeatSphereBackend.repository;

import com.seatsphere.SeatSphereBackend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    // Manages individual seat availability and hall layout
    List<Seat> findByTheaterHallId(Long hallId);
}