# 🎬 SeatSphere (HappySeats) - Movie Ticket Booking System
**Folder:** `1_code`  
**Lead Developer:** Danielle Kemp

---

## 🏗️ Technical Architecture
This project utilizes a **Decoupled Architecture** to separate concerns between the data-processing "Brain" and the user-facing "Interface."

* **Backend:** Java Spring Boot (REST API) running on `Port 8080`.
* **Frontend:** Node.js with the Express framework running on `Port 3000`.
* **Integration:** The frontend is configured with an `npm start` script in the `package.json` to launch the Express server. It serves HTML/CSS/JS files to the browser, which then utilizes the **Fetch API** to communicate with the Java backend via JSON.



## 🛠️ Required Software
* **VS Code** (or equivalent Java/Web IDE)
* **MySQL Workbench**
* **Node.js & NPM**
* **Java JDK 17+**

## 🚀 Startup Sequence (Dual-Terminal Process)
Since the frontend depends on the backend API, follow this exact order:

### 1. Start the Backend (The Brain)
1.  Open the `SeatSphereBackend` folder in VS Code.
2.  Navigate to `SeatSphereBackendApplication.java`.
3.  Run the program.
4.  Wait for the terminal to confirm: `"Started SeatSphereBackendApplication"`.

### 2. Start the Frontend (The Face)
1.  Open a **NEW** terminal window/tab in VS Code.
2.  Navigate to the frontend directory:
    ```bash
    cd SeatSphereFrontend
    ```
3.  Input the command:
    ```bash
    npm start
    ```
4.  The terminal will display: `“SeatSphere Frontend is running at http://localhost:3000”`.

### 3. View Application
Open a web browser and go to: [http://localhost:3000](http://localhost:3000)

> **Note:** To shut down the system, press `CTRL+C` in both terminal windows.