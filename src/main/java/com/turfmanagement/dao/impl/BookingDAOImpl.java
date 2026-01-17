package com.turfmanagement.dao.impl;

import com.turfmanagement.dao.BookingDAO;
import com.turfmanagement.model.Booking;
import com.turfmanagement.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
    @Override
    public boolean createBooking(Booking booking) {
        String query = "INSERT INTO bookings (user_id, slot_id, booking_date, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, booking.getUserId());
            pstmt.setInt(2, booking.getSlotId());
            pstmt.setDate(3, new java.sql.Date(booking.getBookingDate().getTime()));
            pstmt.setString(4, booking.getStatus());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Booking> getBookingsByUserId(int userId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                bookings.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("slot_id"),
                        rs.getDate("booking_date"),
                        rs.getString("status")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public boolean bookSlotTransaction(Booking booking) {
        String insertBooking = "INSERT INTO bookings (user_id, slot_id, booking_date, status) VALUES (?, ?, ?, ?)";
        String updateSlot = "UPDATE slots SET is_available = FALSE WHERE id = ? AND is_available = TRUE";

        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            // 1. Try to update slot availability
            try (PreparedStatement updatePstmt = conn.prepareStatement(updateSlot)) {
                updatePstmt.setInt(1, booking.getSlotId());
                if (updatePstmt.executeUpdate() == 0) {
                    conn.rollback();
                    return false;
                }
            }

            // 2. Insert booking record
            try (PreparedStatement insertPstmt = conn.prepareStatement(insertBooking)) {
                insertPstmt.setInt(1, booking.getUserId());
                insertPstmt.setInt(2, booking.getSlotId());
                insertPstmt.setDate(3, new java.sql.Date(booking.getBookingDate().getTime()));
                insertPstmt.setString(4, booking.getStatus());
                insertPstmt.executeUpdate();
            }

            conn.commit();
            return true;
        } catch (Exception e) {
            if (conn != null)
                try {
                    conn.rollback();
                } catch (Exception ex) {
                }
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (Exception e) {
                }
        }
    }
}
