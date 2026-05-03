# 📑 Manual Test Results

---

## 🧪 Test Environment

The following environment was used to perform all manual tests:

- **Browser:** Chrome / Edge / Firefox  
- **Database:** MySQL 8.0.44  
- **Server:** Node.js environment  

---

## ✅ Core Functional Test Cases

The table below summarizes the results of key system functionality tests:

| Test ID | Feature              | Description                          | Expected Result                                  | Status |
|--------|---------------------|--------------------------------------|--------------------------------------------------|--------|
| TC-01  | User Authentication | Login as `manager_danielle`          | Access to Manager dashboard granted              | PASS   |
| TC-02  | Role-Based Access   | Login as `customer_joe`              | Manager-only features are hidden                 | PASS   |
| TC-03  | Seat Selection      | Select Seat A-1 in Hall 1            | Seat highlights and is added to cart             | PASS   |
| TC-04  | Booking Creation    | Checkout for *Gladiator II*          | New record appears in `bookings` table           | PASS   |
| TC-05  | Ticket Generation   | View "My Tickets" section            | Unique `TKT-` code is generated and displayed    | PASS   |

---

## ⚠️ Edge Case & Logic Testing

These tests validate deeper system logic and database constraints:

- **Duplicate Prevention:**  
  Attempted to book a seat already linked in the `tickets` table for the same `showtime_id`.  
  **Result:** System successfully prevents double-booking.

- **Accessibility Indicators:**  
  Verified that seats marked with `is_handicap` in the `seats` table display the correct UI indicator.  
  **Result:** Handicap icon correctly shown (e.g., Seat A-1 and A-5 in Hall 1).

---

## 🔍 Database Integrity Verification

These checks ensure consistency between backend data and frontend behavior:

- **Data Accuracy:**  
  Verified that *Avatar 3* displays a price of **$15.00** in the UI, matching the `movies` table.

- **Relationship Integrity:**  
  Deleting a test booking correctly removed associated tickets due to the `booking_id` foreign key relationship.

---

## 📸 Evidence (Optional but Recommended)

To strengthen documentation, include screenshots such as:

- **Screenshot 1:** Seat map showing Hall 1’s 24-seat layout  
- **Screenshot 2:** Successful booking confirmation page  
- **Screenshot 3:** `tickets` table in MySQL Workbench with newly created entries  

---
