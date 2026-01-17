package com.turfmanagement.service.impl;

import com.turfmanagement.dao.BookingDAO;
import com.turfmanagement.dao.impl.BookingDAOImpl;
import com.turfmanagement.model.Booking;
import com.turfmanagement.service.BookingService;
import java.util.Date;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    private BookingDAO bookingDAO = new BookingDAOImpl();

    @Override
    public boolean bookSlot(int userId, int slotId) {
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setSlotId(slotId);
        booking.setBookingDate(new Date());
        booking.setStatus("CONFIRMED");

        return bookingDAO.bookSlotTransaction(booking);
    }

    @Override
    public List<Booking> getUserBookings(int userId) {
        return bookingDAO.getBookingsByUserId(userId);
    }
}
