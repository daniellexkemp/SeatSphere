package com.seatsphere.SeatSphereBackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SeatSphereBackendApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        // Verifies the Spring container starts successfully
        assertNotNull(applicationContext, "The application context should not be null on startup.");
    }

    @Test
    void databaseRepositoriesLoad() {
        // Verifies that key repositories are correctly initialized by Spring Data JPA
        // This ensures your SQL table mappings (Movies, Bookings, etc.) are valid
        assertNotNull(applicationContext.getBean("movieRepository"), "MovieRepository should be loaded.");
        assertNotNull(applicationContext.getBean("bookingRepository"), "BookingRepository should be loaded.");
        assertNotNull(applicationContext.getBean("userRepository"), "UserRepository should be loaded.");
    }
}
