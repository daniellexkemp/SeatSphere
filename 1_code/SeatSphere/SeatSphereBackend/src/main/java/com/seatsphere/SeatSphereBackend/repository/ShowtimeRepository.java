package com.seatsphere.SeatSphereBackend.repository;

import com.seatsphere.SeatSphereBackend.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    // Spring looks at 'movie' then 'id' within the Showtime model
    List<Showtime> findByMovieId(Long movieId);
}