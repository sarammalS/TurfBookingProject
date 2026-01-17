package com.turfmanagement.dao.impl;

import com.turfmanagement.dao.TurfDAO;
import com.turfmanagement.model.Turf;
import com.turfmanagement.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TurfDAOImpl implements TurfDAO {
    @Override
    public List<Turf> getAllTurfs() {
        List<Turf> turfs = new ArrayList<>();
        String query = "SELECT * FROM turfs";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                turfs.add(new Turf(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getDouble("price_per_hour"),
                        rs.getString("image_path")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return turfs;
    }

    @Override
    public Turf getTurfById(int id) {
        String query = "SELECT * FROM turfs WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Turf(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getDouble("price_per_hour"),
                        rs.getString("image_path"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addTurf(Turf turf) {
        String query = "INSERT INTO turfs (name, location, description, price_per_hour, image_path) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, turf.getName());
            pstmt.setString(2, turf.getLocation());
            pstmt.setString(3, turf.getDescription());
            pstmt.setDouble(4, turf.getPricePerHour());
            pstmt.setString(5, turf.getImagePath());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
