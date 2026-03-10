package com.seatsphere.SeatSphereBackend.repository;

import com.seatsphere.SeatSphereBackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Used for generating and validating individual admission passes
}