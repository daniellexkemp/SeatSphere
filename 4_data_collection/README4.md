# 🎬 SeatSphere (HappySeats) - Database Assets

This folder contains the complete SQL data lifecycle for the **SeatSphere** movie theater management system. These files provide the foundational schema and pre-populated data required for the final project demonstration.

---

## 🗄️ Database Overview

- **System:** MySQL  
- **Database Name:** `seatsphere_db`  
- **Character Set:** `utf8mb4`  

The database is pre-populated to ensure a consistent, demo-ready environment.

---

## 🛠️ Schema Architecture

The database is structured to support a full-stack booking experience, from seat selection to automated ticket generation.

| Table            | Primary Responsibility |
|------------------|----------------------|
| `users`          | Authentication and role-based permissions (**MANAGER, ADMIN, CUSTOMER**) |
| `movies`         | Film metadata, pricing, and UI asset paths |
| `theater_halls`  | Physical venues (e.g., Hall 1 with 24 seats) |
| `showtimes`      | Movie scheduling across halls and times |
| `seats`          | Individual seat records with accessibility flags |
| `bookings`       | Transaction records linked to users and showtimes |
| `tickets`        | QR-coded tickets generated per reserved seat |

---

## 📋 Key Table Fields (Reference)

- **`users`**: `id`, `username`, `email`, `password`, `role`, `first_name`, `last_name`  
- **`movies`**: `id`, `title`, `genre`, `duration`, `price`, `rating`, `image_path`  
- **`theater_halls`**: `id`, `name`, `total_seats`  
- **`showtimes`**: `id`, `start_time`, `movie_id`, `hall_id`  
- **`seats`**: `id`, `is_occupied`, `seat_number`, `seat_row`, `hall_id`, `is_handicap`  
- **`bookings`**: `id`, `total_amount`, `showtime_id`, `user_id`  
- **`tickets`**: `id`, `qr_code_data`, `booking_id`, `seat_id`  

---

## 🚀 Initialization Guide

To recreate the environment for the final demo, import the SQL files in the following order to satisfy foreign key constraints:

1. `theater_halls.sql`  
2. `movies.sql`  
3. `users.sql`  
4. `seats.sql`  
5. `showtimes.sql`  
6. `bookings.sql`  
7. `tickets.sql`  

---

## 🧪 Demo Data Highlights

The included data dumps are configured for immediate testing:

- **Manager Access:**  
  Log in as `manager_danielle` to test administrative features.

- **Movie Gallery:**  
  13 films are pre-loaded, including *Gladiator II* and *Avatar 3*, with associated media paths.

- **Showtimes:**  
  60+ uniquely scheduled showtimes mapped across multiple halls.

- **Accessibility:**  
  Hall layouts include designated handicap seating (e.g., **Seat A-1 in Hall 1**) to demonstrate inclusive design.

- **Booking Flow:**  
  Fully connected data enables end-to-end testing from seat selection → booking → ticket generation.

---

## 📌 Notes

- Ensure MySQL is running before importing files.  
- Verify database connection settings match your local environment.  
- All scripts are designed to be executed sequentially without modification.  

---
