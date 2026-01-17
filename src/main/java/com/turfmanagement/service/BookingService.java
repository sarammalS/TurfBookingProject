package com.turfmanagement.service;

import com.turfmanagement.model.Booking;
import java.util.List;

public interface BookingService {
    boolean bookSlot(int userId, int slotId);

    List<Booking> getUserBookings(int userId);
}
