# 🎬 SeatSphere (HappySeats) - Movie Ticket Booking System
# 🧪 Logic Validation & Quality Assurance
**Folder:** `2_unit_testing`

## 📝 Description
This folder contains a comprehensive suite of **Unit Tests** designed to verify the reliability of the SeatSphere backend. Using a "Test-Driven" mindset, these scripts ensure that business rules—such as seat accessibility, hall capacity, and dynamic pricing—work perfectly in isolation before integration.



## 🧰 Testing Frameworks & Tools
* **JUnit 5:** Industry-standard framework for executing the test lifecycle.
* **Mockito:** Utilized for "Mocking" repository calls to test Service-level logic without a live MySQL connection.
* **AssertJ:** Used for fluent and readable assertions.

## ✅ Key Business Logic Verified
1.  **Seat Accessibility & Mapping:** Validates `is_handicap` flags to ensure ADA-compliant seating is marked correctly in the UI for Halls 1-6.
2.  **Strict Hall Capacity:** Ensures Halls 1-6 cannot exceed hardcoded limits (20 or 25 seats).
3.  **Dynamic Pricing:** Tests `total_amount` calculations, including tax and service fees, against the 13-movie database.
4.  **Transactional Booking Logic:** Ensures `is_occupied` toggles correctly to prevent "Double Booking."
5.  **Metadata Integrity:** Validates that Movie metadata (Duration, Rating, Image Path) is formatted correctly.

## 📂 Key Test Classes
* `BookingServiceTest`: Validates price calculation and seat occupancy state changes.
* `MovieServiceTest`: Ensures manual data entries for titles are handled correctly.
* `UserValidationTest`: Verifies user roles and contact info constraints.

## 🏃 How to Run
### Method 1: IDE (VS Code/IntelliJ)
1. Navigate to the `src/test/java` folder.
2. Right-click and select **"Run All Tests"**.

### Method 2: Maven Command Line
```bash
mvn test