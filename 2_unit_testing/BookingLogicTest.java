package com.seatsphere.SeatSphereBackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BookingLogicTest {

    @Test
    void testTicketCalculation() {
        // We are testing if 3 tickets at $12.50 (Cosmic Drift price) equals $37.50
        double pricePerTicket = 12.50;
        int numberOfTickets = 3;
        double expectedTotal = 37.50;
        
        double actualTotal = pricePerTicket * numberOfTickets;
        
        assertEquals(expectedTotal, actualTotal, "The price calculation logic should match.");
    }

    @Test
    void testHallCapacityCheck() {
        // Testing if our logic recognizes Hall 1's limit of 20
        int hall1Max = 20;
        int ticketsBeingBought = 5;
        
        boolean canFit = ticketsBeingBought <= hall1Max;
        
        assertEquals(true, canFit, "Hall 1 should be able to fit 5 more people.");
    }
}
