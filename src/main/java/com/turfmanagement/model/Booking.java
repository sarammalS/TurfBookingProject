package com.turfmanagement.model;

import java.util.Date;

public class Booking {
    private int id;
    private int userId;
    private int slotId;
    private Date bookingDate;
    private String status; // "PENDING", "CONFIRMED", "CANCELLED"

    public Booking() {
    }

    public Booking(int id, int userId, int slotId, Date bookingDate, String status) {
        this.id = id;
        this.userId = userId;
        this.slotId = slotId;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
