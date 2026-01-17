# Maintenance & Development Guide

This guide is intended for developers who wish to maintain or extend the TurfSpot system.

## 🛠 Project Structure

- `com.turfmanagement.model`: POJO classes.
- `com.turfmanagement.dao`: Data access interfaces.
- `com.turfmanagement.dao.impl`: JDBC-based implementations of DAOs.
- `com.turfmanagement.service`: Business logic layer.
- `com.turfmanagement.controller`: Servlet logic (Handling requests).
- `com.turfmanagement.util`: Utilities for DB connection and password hashing.
- `webapp/jsp`: Front-end presentation.
- `webapp/css`: Styling.

## ➕ Adding a New Feature

To add a new entity (e.g., "Payments"):
1. Create the `Payment` model.
2. Create the `PaymentDAO` interface and `PaymentDAOImpl`.
3. Create the `PaymentService` interface and `PaymentServiceImpl`.
4. Register the new service in the `PaymentServlet`.
5. Create the JSPs in the `webapp/jsp` folder.

## 🧪 Testing
- The system is designed for **Unit Testing** by mocking the Service and DAO interfaces.
- Use **JUnit 5** and **Mockito** for tests (Dependencies should be added to `pom.xml`).

## 🔄 Database Migrations
- All structural changes should be reflected in `schema.sql`.
- Follow **ACID** principles when modifying transactions, especially in `BookingDAOImpl`.

## 📦 Deployment
- Ensure `db.properties` is correctly configured for the target environment.
- Use `mvn clean package` to generate the WAR file.
- Support for Dockerization can be added by creating a `Dockerfile` with a Tomcat base image.
