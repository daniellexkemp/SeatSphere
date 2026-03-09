# 🎬 SeatSphere (HappySeats) - Movie Ticket Booking System
# 📊 Data Collection & Database Schema
**Folder:** `4_data_collection`

## 🗄️ Database: MySQL
The database is pre-populated manually to ensure a consistent demonstration environment.


## 📋 Tables & Schema
* **`movies`**: `id`, `title`, `genre`, `duration`, `price`, `rating`, `image_path`.
* **`theater_halls`**: `id`, `name` (Hall 1-6), `total_seats` (20 or 25).
* **`showtimes`**: `id`, `start_time`, `movie_id`, `hall_id`. (**62 unique entries**).
* **`seats`**: `id`, `is_occupied`, `seat_number`, `seat_row`, `hall_id`, `is_handicap`.
* **`bookings`**: `id`, `total_amount`, `showtime_id`, `user_id`.
* **`tickets`**: `id`, `qr_code_data`, `booking_id`, `seat_id`.
* **`users`**: `id`, `username`, `email`, `password`, `role`, `first_name`, `last_name`.

## 📌 Data Sample
* **Movies:** 13 titles including *Cosmic Drift*, *K-Pop Demon Hunter*, and *Avatar 3*.
* **Showtimes:** 62 uniquely connected showtimes.
* **Seats:** Configured for accessibility with `is_handicap` flags.

> **Note:** No default demo user is required; the system is currently demonstrated using Guest data entered during the Checkout phase.
