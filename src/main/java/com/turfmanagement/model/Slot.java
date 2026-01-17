package com.turfmanagement.model;

import java.sql.Time;
import java.util.Date;

public class Slot {
    private int id;
    private int turfId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private boolean isAvailable;

    public Slot() {}

    public Slot(int id, int turfId, Date date, Time startTime, Time endTime, boolean isAvailable) {
        this.id = id;
        this.turfId = turfId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isAvailable = isAvailable;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTurfId() { return turfId; }
    public void setTurfId(int turfId) { this.turfId = turfId; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Time getStartTime() { return startTime; }
    public void setStartTime(Time startTime) { this.startTime = startTime; }

    public Time getEndTime() { return endTime; }
    public void setEndTime(Time endTime) { this.endTime = endTime; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}
