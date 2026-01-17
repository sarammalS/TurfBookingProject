package com.turfmanagement.dao.impl;

import com.turfmanagement.dao.ReviewDAO;
import com.turfmanagement.model.Review;
import com.turfmanagement.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl implements ReviewDAO {
    @Override
    public boolean addReview(Review review) {
        String query = "INSERT INTO reviews (user_id, turf_id, rating, comment, review_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, review.getUserId());
            pstmt.setInt(2, review.getTurfId());
            pstmt.setInt(3, review.getRating());
            pstmt.setString(4, review.getComment());
            pstmt.setDate(5, new java.sql.Date(review.getReviewDate().getTime()));
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Review> getReviewsByTurfId(int turfId) {
        List<Review> reviews = new ArrayList<>();
        String query = "SELECT * FROM reviews WHERE turf_id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, turfId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                reviews.add(new Review(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("turf_id"),
                        rs.getInt("rating"),
                        rs.getString("comment"),
                        rs.getDate("review_date")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }
}
