package com.seatsphere.SeatSphereBackend.config;

// import com.seatsphere.SeatSphereBackend.model.*;
// import com.seatsphere.SeatSphereBackend.repository.*;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import java.time.LocalDateTime;

// @Configuration
// public class DataInitializer {

//     @Bean
//     CommandLineRunner initDatabase(
//             MovieRepository movieRepo, 
//             TheaterHallRepository hallRepo, 
//             ShowtimeRepository showtimeRepo,
//             UserRepository userRepo) {
//         return args -> {
//             // 1. Create Demo User
//             if (userRepo.count() == 0) {
//                 User demoUser = new User();
//                 demoUser.setFirstName("Danielle");
//                 demoUser.setLastName("Kemp");
//                 demoUser.setUsername("LuckyGuest26");
//                 demoUser.setEmail("guest@happyseats.com");
//                 demoUser.setPassword("password123");
//                 demoUser.setRole("Customer");
//                 userRepo.save(demoUser);
//                 System.out.println("--- Demo User Loaded ---");
//             }

//             // 2. Create Theater Halls
//             if (hallRepo.count() == 0) {
//                 TheaterHall h1 = new TheaterHall("Grand IMAX", 100, "IMAX");
//                 TheaterHall h2 = new TheaterHall("Screen 2", 50, "Standard");
//                 hallRepo.save(h1);
//                 hallRepo.save(h2);

//                 // 3. Create 8 Movies and Showtimes
//                 Movie m1 = saveMovie(movieRepo, "Dracula", "Horror", "R", 12.50, 100);
//                 Movie m2 = saveMovie(movieRepo, "Zootopia 2", "Animation", "PG", 10.00, 110);
//                 Movie m3 = saveMovie(movieRepo, "Avatar 3", "Sci-Fi", "PG-13", 15.00, 180);
//                 Movie m4 = saveMovie(movieRepo, "The Batman", "Action", "PG-13", 13.00, 175);
//                 Movie m5 = saveMovie(movieRepo, "Toy Story 5", "Family", "G", 10.00, 95);
//                 Movie m6 = saveMovie(movieRepo, "Inception", "Sci-Fi", "PG-13", 12.00, 148);
//                 Movie m7 = saveMovie(movieRepo, "Interstellar", "Drama", "PG-13", 12.00, 169);
//                 Movie m8 = saveMovie(movieRepo, "Gladiator II", "Epic", "R", 14.00, 150);

//                 createShowtime(showtimeRepo, m1, h1, 19, 30);
//                 createShowtime(showtimeRepo, m2, h2, 13, 0);
//                 createShowtime(showtimeRepo, m3, h1, 14, 0);
//                 createShowtime(showtimeRepo, m4, h1, 18, 0);
//                 createShowtime(showtimeRepo, m5, h2, 16, 0);
//                 createShowtime(showtimeRepo, m6, h1, 20, 0);
//                 createShowtime(showtimeRepo, m7, h2, 11, 30);
//                 createShowtime(showtimeRepo, m8, h1, 22, 0);

//                 System.out.println("--- 8 Movies and Showtimes Loaded Successfully! ---");
//             }
//         };
//     }

//     private Movie saveMovie(MovieRepository repo, String title, String genre, String rating, double price, int duration) {
//         Movie m = new Movie(title, genre, duration, rating, price);
//         return repo.save(m);
//     }

//     private void createShowtime(ShowtimeRepository repo, Movie m, TheaterHall h, int hour, int min) {
//         Showtime s = new Showtime();
//         s.setMovie(m);
//         s.setTheaterHall(h);
//         s.setStartTime(LocalDateTime.now().withHour(hour).withMinute(min));
//         repo.save(s);
//     }
// }