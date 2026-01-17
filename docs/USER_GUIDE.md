# User Guide - TurfSpot

Welcome to the TurfSpot User Guide. This document provides step-by-step instructions on how to use the Turf Management System.

## 👥 For Users

### 1. Registration & Login
- Navigate to the home page (login.jsp).
- If you don't have an account, click **Register**.
- Fill in your username, email, and password.
- Once registered, login with your credentials.

### 2. Browsing Turfs
- After logging in, you'll be redirected to the **Dashboard**.
- Click on **View Turfs** to see all available sports grounds.
- Each turf displays its name, location, and price per hour.

### 3. Booking a Slot
- Click **View Details** on any turf.
- You will see a list of available time slots for that turf.
- Click **Book Now** on your preferred slot.
- Your booking will be confirmed immediately, and the slot will become unavailable for others.

### 4. Managing Bookings
- View your reservation history on the **Dashboard**.
- See the status of your bookings (e.g., CONFIRMED).

### 5. Writing Reviews
- On the Turf Details page, you can scroll down to the **Reviews** section.
- Provide a rating (1-5) and a comment about your experience.

---

## 🔑 For Administrators

> [!NOTE]
> Admin roles are assigned in the `users` table with the `role` set to 'ADMIN'.

### 1. Adding New Turfs
- Access the Admin Dashboard (TBD/Direct Link).
- Fill in the Turf name, location, price, and description.
- Provide an image URL or upload an image (if implemented).

### 2. Managing Slots
- Admins can create new slots for any turf.
- Set the date, start time, and end time.
- Mark slots as available or unavailable manually if needed.
