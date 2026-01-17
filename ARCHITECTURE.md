# Architecture & Design Documentation

This document explains the architectural decisions and design patterns used in the Turf Management System.

## 🏛 Clean Architecture Layers

1. **Model Layer**: POJOs representing core entities (`User`, `Turf`, `Slot`, etc.).
2. **DAO Layer (Data Access Object)**: Interfaces and implementations for database operations.
3. **Service Layer**: Business logic encapsulated in services, acting as a bridge between Controllers and DAOs.
4. **Controller Layer**: Servlets handling HTTP requests and session management.
5. **View Layer**: JSPs for presentation.

## ⚖ SOLID Principles Implementation

### Single Responsibility (SRP)
Each component has one reason to change:
- `UserDAO`: Pure database operations for users.
- `AuthFilter`: Handles ONLY session and access control.
- `PasswordUtil`: Focused solely on hashing and verification.

### Open/Closed (OCP)
The use of interfaces in the DAO and Service layers allows us to add new implementations (e.g., swapping MySQL for PostgreSQL or adding a new notification service) without changing the existing business logic.

### Liskov Substitution (LSP)
The system is designed such that different user roles (Admin vs. Normal User) can be handled interchangeably where they share common attributes, while specific behaviors are scoped correctly.

### Interface Segregation (ISP)
Instead of a monolithic `SystemDAO`, we have specific interfaces like `UserDAO`, `BookingDAO`, and `TurfDAO`. This ensures that a component only knows about the methods it actually uses.

### Dependency Inversion (DIP)
The Servlet layer depends on Service **interfaces**, not the implementations. This decoupling makes the system more testable and flexible.

## 🗄 Database Normalization (BCNF)

The database schema is fully normalized to **BCNF (Boyce-Codd Normal Form)**:
- **1NF**: Atomic values, unique rows, no repeating groups.
- **2NF**: 1NF + no partial functional dependencies.
- **3NF**: 2NF + no transitive functional dependencies.
- **BCNF**: For every functional dependency $X \to Y$, $X$ is a superkey.

This ensures:
- **No Data Redundancy**: Information is stored once.
- **Data Integrity**: Updates and deletions don't cause anomalies.
- **Optimized Performance**: Smaller, focused tables.

## 🔒 Security & ACID Properties

- **Security**: BCrypt is used for password hashing. `AuthFilter` provides role-based access control.
- **ACID Compliance**: The MySQL engine ensures Atomicity, Consistency, Isolation, and Durability for all booking transactions, preventing double bookings even under high load.
