package com.turfmanagement.service;

import com.turfmanagement.model.Review;
import java.util.List;

public interface ReviewService {
    boolean addReview(Review review);

    List<Review> getTurfReviews(int turfId);
}
