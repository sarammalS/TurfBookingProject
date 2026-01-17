
# Turf Management System (TurfSpot)

A comprehensive Turf Management System built with Java Servlets, JSP, and MySQL, following SOLID principles and Clean Architecture.

##  Project Outcome

The project works end-to-end:
- **Admin**: Manages turfs, slots, images, and bookings.
- **Users**: Search turfs, check availability, book slots, and view history.
- **Security**: Prevents double booking and ensures secure access.
- **Architecture**: Built with proper SOLID principles and a normalized database (BCNF).

##  Features

- **User Authentication**: Secure Login/Logout/Registration with BCrypt.
- **Dashboard**: Interactive user dashboard to explore turfs and manage bookings.
- **Turf Management**: Complete CRUD for turf owners.
- **Slot Management**: Granular control over booking slots and pricing.
- **Booking Engine**: Reliable reservation system with concurrency checks.
- **Reviews & Ratings**: User feedback system for quality assurance.

##  Architecture & Design Patterns

### SOLID Principles
- **Single Responsibility**: Servlets, Services, and DAOs have a single core task.
- **Open/Closed**: Logic is extensible without modifying core classes.
- **Liskov Substitution**: Role-based behavior follows consistent patterns.
- **Interface Segregation**: Specific DAO and Service interfaces.
- **Dependency Inversion**: High-level modules depend on abstractions.

### Database Normalization
The schema follows **1NF, 2NF, 3NF, and BCNF** to ensure data integrity and zero redundancy.

## Tech Stack
- **Backend**: Java 17, Servlets 4.0
- **Frontend**: JSP, JSTL, Vanilla CSS, JavaScript
- **Database**: MySQL 8.0
- **Security**: BCrypt Hashing, Session management
- **Build Tool**: Maven

## Documentation

For more detailed information, please refer to:
- [User Guide](docs/USER_GUIDE.md) - How to use the app.
- [API Specification](docs/API_SPEC.md) - Endpoint details.
- [Database Model](docs/DATABASE_MODEL.md) - Schema and ERD.
- [Architecture Guide](ARCHITECTURE.md) - SOLID & Design Patterns.
- [Maintenance Guide](docs/MAINTENANCE.md) - For developers.

##  Getting Started

### Prerequisites
- JDK 17+
- MySQL Server
- Apache Tomcat 9+

### Setup
1. Clone the repository.
2. Run `schema.sql` in your MySQL database.
3. Update `src/main/resources/db.properties` with your credentials.
4. Run `mvn clean package`.
5. Deploy the `target/TurfManagementSystem.war` to Tomcat.


