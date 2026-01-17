package com.turfmanagement.model;

import java.util.Date;

public class Review {
    private int id;
    private int userId;
    private int turfId;
    private int rating; // 1-5
    private String comment;
    private Date reviewDate;

    public Review() {
    }

    public Review(int id, int userId, int turfId, int rating, String comment, Date reviewDate) {
        this.id = id;
        this.userId = userId;
        this.turfId = turfId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
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

    public int getTurfId() {
        return turfId;
    }

    public void setTurfId(int turfId) {
        this.turfId = turfId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
