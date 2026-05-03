# 🎬 SeatSphere (HappySeats) - Movie Ticket Booking System
**Folder:** `1_code`  
**Lead Developer:** Danielle Kemp

---

## 🏗️ Technical Architecture
This project utilizes a **Decoupled Full-Stack Architecture**, ensuring a clear separation between data management, business logic, and user interface.

* **Backend:** Java Spring Boot (REST API) running on `Port 8080`.
* **Frontend:** Node.js with the Express framework running on `Port 3000`.
* **Integration:** The frontend is configured with an `npm start` script in the `package.json` to launch the Express server. It serves HTML/CSS/JS files to the browser, which then utilizes the **Fetch API** to communicate with the Java backend via JSON.



## 🛠️ Required Software
* **VS Code** (or equivalent Java/Web IDE) (Recommended extensions: *Spring Boot Extension Pack* and *MySQL*)
* **MySQL Server & Workbench** (To host the theater schema)
* **Node.js (v18+) & NPM** (For Express Frontend)
* **Java JDK 17+** (For Spring Boot Backend)

## 🚀 Startup Sequence (Triple-Terminal Process)
To ensure data integrity, the database and backend services must be active before the frontend is launched.

### 1. Initialize the Database
1.  Open **MySQL Workbench** and connect to your local instance.
2.  Run the provided SQL scripts in order (from the `0_database` folder) to build the schema and seed the data.

### 2. Start the Backend (API)
1.  Open the `SeatSphereBackend` folder in VS Code.
2.  Navigate to `src/main/java/com/seatsphere/SeatSphereBackend/SeatSphereBackendApplication.java`.
3.  Run the application. 
4.  Confirm the console shows: `Tomcat started on port(s): 8080 (http)`.

### 3. Start the Frontend (UI)
1.  Open a **NEW** terminal window in VS Code.
2.  Navigate to the frontend directory:
    ```bash
    cd SeatSphereFrontend
    ```
3.  Run the command:
    ```bash
    npm start
    ```
4.  The terminal will confirm: `“SeatSphere Frontend is running at http://localhost:3000”`.

### 4. View Application
Launch your browser and visit: [http://localhost:3000](http://localhost:3000)

> **Note:** For the best experience, log in as `manager_danielle` to access full administrative controls.
