# 🎬 SeatSphere (HappySeats) - Movie Ticket Booking System
# 🧪 Logic Validation & Quality Assurance
**Folder:** `2_unit_testing`

## 📝 Description
This folder contains a comprehensive suite of **Unit Tests** designed to verify the reliability of the SeatSphere backend. These tests ensure that critical rules—such as seat accessibility, hall capacity, and pricing—function correctly in isolation before the system interacts with the live MySQL database.


## 🧰 Testing Frameworks & Tools
* **JUnit 5:** The primary framework used for managing and executing the test lifecycle.
* **Mockito:** Utilized in `SeatSphereBackendApplicationTests.java` to verify the application context and repository injection.
* **AssertJ/JUnit Assertions:** Used for fluent and readable assertions.

## ✅ Key Business Logic Verified
1.  **Seat Accessibility & Mapping:** Validates that seats marked as `is_handicap: 1` in the database (such as Seat A-1 and A-5 in Hall 1) are correctly identified by the backend logic.
2.  **Strict Hall Capacity:** Ensures the system recognizes the specific seat limits for each venue, such as the 24-seat capacity for Hall 1 and the 32-seat capacity for Hall 2.
3.  **Calculated Pricing:** Verifies that the`total_amount` for bookings accurately reflects the movie's price metadata (e.g., confirming 3 tickets for Cosmic Drift equals $37.50).
4.  **Database Integration Readiness:** Uses `SeatSphereBackendApplicationTests.java` to confirm that the Spring context can successfully load and inject repositories for Movies, Bookings, and Users, ensuring the code is ready to "talk" to the SQL schema.
5.  **Metadata Integrity:** Validates that movie metadata—including durations, ratings (R, PG-13, G), and media paths—is correctly handled by the service layer.

## 📂 Key Test Classes
* `BookingLogicTest.java`: Focuses on the math and rules behind reservations, including capacity checks and handicap seat identification.
* `SeatSphereBackendApplicationTests.java`: A comprehensive "smoke test" that ensures the Spring Boot environment and all JPA Repositories (Movie, Booking, User) initialize without errors.

## 🏃 How to Run
### Method 1: IDE (VS Code/IntelliJ)
1. Navigate to src/test/java/com/seatsphere/SeatSphereBackend.
2. Right-click the folder or a specific file and select "Run Tests".

### Method 2: Maven Command Line
```bash
mvn test
