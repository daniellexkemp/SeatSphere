package com.seatsphere.SeatSphereBackend.repository;

import com.seatsphere.SeatSphereBackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
    // Find all tickets for a specific booking (Great for the Staff/Manager page)
    List<Ticket> findByBookingId(Long bookingId);

    // ticketrepository.java
    // Find all tickets for a specific showtime to identify reserved seats
    List<Ticket> findByBooking_Showtime_Id(Long showtimeId);

    // New version of the check: Does a ticket already exist for this specific seat at this showtime?
    boolean existsBySeatRowAndSeatNumberAndBooking_Showtime_Id(String seatRow, int seatNumber, Long showtimeId);

    // Find a ticket by its QR code for staff validation
    Ticket findByQrCodeData(String qrCodeData);
}
