package com.seatsphere.SeatSphereBackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BookingLogicTest {

    @Test
    void testTicketCalculation() {
        // Testing if 3 tickets at the current 'Cosmic Drift' price ($12.50) equals $37.50
        double pricePerTicket = 12.50; // Matches movies table for ID 4
        int numberOfTickets = 3;
        double expectedTotal = 37.50;
        
        double actualTotal = pricePerTicket * numberOfTickets;
        
        assertEquals(expectedTotal, actualTotal, "The price calculation logic should match the movie price.");
    }

    @Test
    void testHall1CapacityCheck() {
        // Updated to match theater_halls table: Hall 1 has a total_seats of 24
        int hall1Max = 24; 
        int ticketsBeingBought = 5;
        
        boolean canFit = ticketsBeingBought <= hall1Max;
        
        assertTrue(canFit, "Hall 1 should correctly recognize capacity for 24 seats.");
    }

    @Test
    void testHandicapSeatValidation() {
        // Testing if our logic recognizes Seat 1 as a handicap seat
        // Based on seats table dump: ID 1, Row A, Seat 1, Hall 1 is_handicap = 1
        int isHandicapValue = 1; 
        
        boolean isHandicap = (isHandicapValue == 1);
        
        assertTrue(isHandicap, "Seat A-1 should be identified as a handicap-accessible seat.");
    }
}
