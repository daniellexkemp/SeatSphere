package com.seatsphere.SeatSphereBackend.repository;

import com.seatsphere.SeatSphereBackend.model.TheaterHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterHallRepository extends JpaRepository<TheaterHall, Long> {
    // Automatically handles hall creation and capacity management
}