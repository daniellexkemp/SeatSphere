# 🎟️ SeatSphere: Movie Ticket Booking System
**Lead Developer:** Danielle Kemp  
**Version:** 2.0  
**Tech Stack:** Java Spring Boot, Node.js, MySQL

---

<p align="center">
  <img src="./3_integration_testing/screenshots/3_ui_home.png" width="500" alt="SeatSphere Home Screen">
</p>

## 📖 Project Overview
**SeatSphere** (branded as *HappySeats*) is a full-stack, decoupled web application designed to streamline the cinema-going experience. Users can browse a curated selection of 13 movies, view 62 unique showtimes across 6 different theater halls, and reserve seats with real-time accessibility (ADA) considerations.

### Key Features:
* **Decoupled Architecture:** Separate Backend (API) and Frontend (UI) for maximum scalability.
* **Dynamic Seat Mapping:** Automated hall layouts (20 or 25 seats) with handicap-accessible designations.
* **Secure Transactions:** Simulated checkout process with unique QR-code ticket generation.
* **Relational Data:** Robust MySQL schema managing complex relationships between movies, showtimes, and seating.



---

## 📁 Repository Structure
This repository is organized into four main modules. Please click into each folder to view its specific documentation:

1.  [**1_code**](./1_code/): Contains the Java Spring Boot Backend and the Node.js Frontend.
2.  [**2_unit_testing**](./2_unit_testing/): Test suites for logic validation.
3.  [**3_integration_testing**](./3_integration_testing/): End-to-end flow documentation and Postman collections.
4.  [**4_data_collection**](./4_data_collection/): MySQL schema dumps, ER Diagrams, and data entry logs.
4. [**5_documentation**](./5_documentation/): Documentation containing Presentation Slides, System Requirements Documentation, and Brochure (with demo) 

---

## 🏗️ Technical Architecture & File Map

SeatSphere utilizes a decoupled Full-Stack architecture. The **Java Spring Boot API** manages the business logic and database persistence, while the **Node.js/Express Frontend** provides a responsive, interactive user experience.
```
📦 SEATSPHERE
┣ 📂 SeatSphereBackend
┃ ┣ 📂 src/main/java/com/seatsphere
┃ ┃ ┣ 📂 config
┃ ┃ ┣ 📂 controller
┃ ┃ ┃  ┣ ☕ BookingController.java
┃ ┃ ┃  ┣ ☕ MovieController.java
┃ ┃ ┃  ┣ ☕ SeatController.java
┃ ┃ ┃  ┣ ☕ ShowtimeController.java
┃ ┃ ┃  ┣ ☕ TheaterController.java
┃ ┃ ┃  ┣ ☕ UserController.java
┃ ┃ ┃  ┗ ☕ ViewController.java
┃ ┃ ┣ 📂 model
┃ ┃ ┃  ┣ ☕ Booking.java
┃ ┃ ┃  ┣ ☕ Movie.java
┃ ┃ ┃  ┣ ☕ Seat.java
┃ ┃ ┃  ┣ ☕ SeatResponseDTO.java
┃ ┃ ┃  ┣ ☕ Showtime.java
┃ ┃ ┃  ┣ ☕ TheaterHall.java
┃ ┃ ┃  ┣ ☕ Ticket.java
┃ ┃ ┃  ┗ ☕ User.java
┃ ┃ ┣ 📂 repository
┃ ┃ ┃  ┣ ☕ BookingRepository.java
┃ ┃ ┃  ┣ ☕ MovieRepository.java
┃ ┃ ┃  ┣ ☕ SeatRepository.java
┃ ┃ ┃  ┣ ☕ ShowtimeRepository.java
┃ ┃ ┃  ┣ ☕ TheaterHallRepository.java
┃ ┃ ┃  ┣ ☕ TicketRepository.java
┃ ┃ ┃  ┗ ☕  UserRepository.java
┃ ┃ ┃  ┗ ☕ 
┃ ┃ ┣ 📂 service
┃ ┃ ┃  ┣ ☕ BookingService.java
┃ ┃ ┃  ┣ ☕ MovieService.java
┃ ┃ ┃  ┣ ☕ SeatService.java
┃ ┃ ┃  ┣ ☕ TheaterService.java
┃ ┃ ┃  ┗ ☕ UserService.java
┃ ┃ ┗ ☕ SeatSphereBackendApplication.java
┃ ┗ 📂 src/main/resources
┃
┗ 📂 SeatSphereFrontend
  ┣ 📂 public
  ┃ ┣ 📂 css
  ┃ ┣  ┗ 🎨style.css
  ┃ ┣ 📂 js
  ┃ ┃  ┣ ⚡auth.js
  ┃ ┃  ┣ ⚡checkout.js
  ┃ ┃  ┣ ⚡confirmation.js
  ┃ ┃  ┣ ⚡script.js
  ┃ ┃  ┗ ⚡seats.js
  ┃ ┗ 📂 📷 media
  ┣ 📜 index.html
  ┣ 📜 seats.html
  ┣ 📜 checkout.html
  ┣ 📜 confirmation.html
  ┣ 📜 dashboard.html
  ┗ ⚡ server.js
```
---

## 🛠️ Technology Stack
| Layer | Technology |
| :--- | :--- |
| **Frontend** | HTML5, CSS3, Bootstrap 5, JavaScript (ES6), Node.js, Express |
| **Backend** | Java 17, Spring Boot, Spring Data JPA, Hibernate |
| **Database** | MySQL 8.0 |
| **Testing** | JUnit 5, Mockito, AssertJ |
| **Tools** | Maven, VS Code, MySQL Workbench, Git |

---

## 🚀 Quick Start
To get this project running on your local machine:

1.  **Clone the Repo:**
    ```bash
    git clone [https://github.com/daniellexkemp/SeatSphere.git](https://github.com/daniellexkemp/SeatSphere.git)
    ```
2.  **Database Setup:** Import the `.sql` file found in `/4_data_collection` into your MySQL Workbench.
3.  **Run Backend:** Navigate to `/1_code/SeatSphereBackend` and run the Spring Boot application.
4.  **Run Frontend:** Navigate to `/1_code/SeatSphereFrontend`, run `npm install`, then `npm start`.

*Detailed startup instructions can be found in the [1_code README1](./1_code/).*



---

## 🛡️ Privacy & Security
* All sensitive database credentials in `application.properties` have been replaced with environmental variables/placeholders.
* User data in the SQL dump has been redacted or anonymized for public viewing.
