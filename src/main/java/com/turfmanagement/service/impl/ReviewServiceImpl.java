package com.turfmanagement.service.impl;

import com.turfmanagement.dao.ReviewDAO;
import com.turfmanagement.dao.impl.ReviewDAOImpl;
import com.turfmanagement.model.Review;
import com.turfmanagement.service.ReviewService;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    private ReviewDAO reviewDAO = new ReviewDAOImpl();

    @Override
    public boolean addReview(Review review) {
        return reviewDAO.addReview(review);
    }

    @Override
    public List<Review> getTurfReviews(int turfId) {
        return reviewDAO.getReviewsByTurfId(turfId);
    }
}
