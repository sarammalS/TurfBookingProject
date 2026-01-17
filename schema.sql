CREATE DATABASE IF NOT EXISTS turf_db;
USE turf_db;

-- Users table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role ENUM('ADMIN', 'USER') DEFAULT 'USER'
);

-- Turfs table
CREATE TABLE IF NOT EXISTS turfs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(255) NOT NULL,
    description TEXT,
    price_per_hour DECIMAL(10, 2) NOT NULL,
    image_path VARCHAR(255)
);

-- Slots table
CREATE TABLE IF NOT EXISTS slots (
    id INT AUTO_INCREMENT PRIMARY KEY,
    turf_id INT NOT NULL,
    date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    is_available BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (turf_id) REFERENCES turfs(id) ON DELETE CASCADE
);

-- Bookings table
CREATE TABLE IF NOT EXISTS bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    slot_id INT NOT NULL,
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('PENDING', 'CONFIRMED', 'CANCELLED') DEFAULT 'PENDING',
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (slot_id) REFERENCES slots(id) ON DELETE CASCADE
);

-- Reviews table
CREATE TABLE IF NOT EXISTS reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    turf_id INT NOT NULL,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    review_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (turf_id) REFERENCES turfs(id) ON DELETE CASCADE
);

-- Sample Data
INSERT INTO turfs (name, location, description, price_per_hour, image_path) VALUES
('Green Valley Turf', 'Downtown Area', 'A lush green turf suitable for football and cricket.', 50.00, 'https://images.unsplash.com/photo-1551958219-acbc608c6377?w=800'),
('Elite Arena', 'West Side', 'Premium indoor turf with air conditioning.', 75.00, 'https://images.unsplash.com/photo-1574629810360-7efbbe195018?w=800');

-- Add some slots for today and tomorrow
INSERT INTO slots (turf_id, date, start_time, end_time) VALUES
(1, CURDATE(), '17:00:00', '18:00:00'),
(1, CURDATE(), '18:00:00', '19:00:00'),
(2, CURDATE(), '20:00:00', '21:00:00'),
(1, DATE_ADD(CURDATE(), INTERVAL 1 DAY), '09:00:00', '10:00:00');
