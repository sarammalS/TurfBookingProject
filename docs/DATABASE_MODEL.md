# Database Documentation

The TurfSpot system uses a MySQL relational database. The schema is optimized for data integrity and follows BCNF.

## 📊 Entity Relationship Diagram

```mermaid
erDiagram
    USERS ||--o{ BOOKINGS : makes
    USERS ||--o{ REVIEWS : writes
    TURFS ||--|{ SLOTS : contains
    TURFS ||--o{ REVIEWS : receives
    SLOTS ||--o{ BOOKINGS : reserved_in

    USERS {
        int id PK
        string username
        string password
        string email
        string role
    }

    TURFS {
        int id PK
        string name
        string location
        string description
        decimal price_per_hour
        string image_path
    }

    SLOTS {
        int id PK
        int turf_id FK
        date date
        time start_time
        time end_time
        boolean is_available
    }

    BOOKINGS {
        int id PK
        int user_id FK
        int slot_id FK
        date booking_date
        string status
    }

    REVIEWS {
        int id PK
        int user_id FK
        int turf_id FK
        int rating
        string comment
        date review_date
    }
```

## 📋 Table Descriptions

### `users`
Stores user credentials and roles. Passwords are encrypted using BCrypt.

### `turfs`
Details of the sports grounds available for booking.

### `slots`
Inventory of time slots for each turf. A slot is the unit of reservation.

### `bookings`
Links a user to a specific slot on a specific date.

### `reviews`
User feedback and ratings for specific turfs.
