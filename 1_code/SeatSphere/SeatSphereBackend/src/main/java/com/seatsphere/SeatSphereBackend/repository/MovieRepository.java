package com.seatsphere.SeatSphereBackend.repository;

import com.seatsphere.SeatSphereBackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Basic CRUD (Create, Read, Update, Delete) are included automatically!
    List<Movie> findByTitleContainingIgnoreCase(String title);
}

