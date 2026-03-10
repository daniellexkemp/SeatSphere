package com.seatsphere.SeatSphereBackend.repository;

import com.seatsphere.SeatSphereBackend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Eagerly fetch showtime and theaterHall for confirmation page
    @Query("SELECT b FROM Booking b " +
           "JOIN FETCH b.showtime s " +
           "JOIN FETCH s.theaterHall " +
           "WHERE b.id = :id")
    Booking findBookingWithShowtimeAndHall(@Param("id") Long id);
}