# 🎬 SeatSphere (HappySeats) - Movie Ticket Booking System
### Folder 3: `3_integration_testing/README.md`

# 🔗 Integration Testing
**Folder:** `3_integration_testing`

## 📝 Description
This section tests the end-to-end user flow and the communication between the **Node.js frontend (Port 3000)** and the **Java API (Port 8080)**.

## 🖼️ Integration Proof & UI Gallery

### 🖥️ System Connectivity
To verify the handshake between the Java API and the Node.js frontend, both servers were initialized and verified.

| Backend (Port 8080) | Frontend (Port 3000) |
| :--- | :--- |
| ![Backend](./Screenshots/0_backend_live.png) | ![Frontend](./Screenshots/0_frontend_live.png) |

---

### 🛣️ The User Journey Flow
1. **`register.html`**: New users register details, which are persisted to the `users` table with the default `CUSTOMER` role.
   ![Register Page](./Screenshots/1_ui_create_account.png)
2.  **`login.html`**: Authenticates credentials against the database to establish a secure session.
   ![Login Page](./Screenshots/2_ui_login.png)
3.  **`index.html`**: Fetches movie list (Dracula, Zootopia 2, etc.) and 60+ showtimes from MySQL.
   ![Home Page](./Screenshots/3_ui_home.png)
4.  **`seats.html`**: Retrieves specific layouts for Halls 1-6 and maps `is_handicap` seats.
   ![Seating](./Screenshots/4_ui_seats.png)
5.  **`checkout.html`**: Collects guest info (Email, Card, Phone) and POSTs booking data.
   ![Confirmation](./Screenshots/5_ui_checkout.png)
6.  **`confirmation.html`**: Retrieves the generated Booking ID and QR code for the final receipt.
   ![Confirmation](./Screenshots/6_ui_confirmation.png)
7. **`dashboard.html`**: Retrieves the generated Booking ID and QR code for the final receipt.
   ![Confirmation](./Screenshots/7_ui_bookings_admin_dashboard.png)



---

## 🛠️ Ongoing Development
* **None at this time but stay tuned for more.** 


