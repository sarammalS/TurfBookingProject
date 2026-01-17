package com.turfmanagement.dao;

import com.turfmanagement.model.Booking;
import java.util.List;

public interface BookingDAO {
    boolean createBooking(Booking booking);

    List<Booking> getBookingsByUserId(int userId);

    boolean bookSlotTransaction(Booking booking);
}
