package com.turfmanagement.dao.impl;

import com.turfmanagement.dao.SlotDAO;
import com.turfmanagement.model.Slot;
import com.turfmanagement.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SlotDAOImpl implements SlotDAO {
    @Override
    public List<Slot> getSlotsByTurfId(int turfId) {
        List<Slot> slots = new ArrayList<>();
        String query = "SELECT * FROM slots WHERE turf_id = ? AND is_available = TRUE";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, turfId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                slots.add(new Slot(
                        rs.getInt("id"),
                        rs.getInt("turf_id"),
                        rs.getDate("date"),
                        rs.getTime("start_time"),
                        rs.getTime("end_time"),
                        rs.getBoolean("is_available")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slots;
    }

    @Override
    public boolean updateSlotAvailability(int slotId, boolean isAvailable) {
        String query = "UPDATE slots SET is_available = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, isAvailable);
            pstmt.setInt(2, slotId);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Slot getSlotById(int id) {
        String query = "SELECT * FROM slots WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Slot(
                        rs.getInt("id"),
                        rs.getInt("turf_id"),
                        rs.getDate("date"),
                        rs.getTime("start_time"),
                        rs.getTime("end_time"),
                        rs.getBoolean("is_available"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
