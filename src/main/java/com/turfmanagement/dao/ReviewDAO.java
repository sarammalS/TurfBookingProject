package com.turfmanagement.dao;

import com.turfmanagement.model.Review;
import java.util.List;

public interface ReviewDAO {
    boolean addReview(Review review);

    List<Review> getReviewsByTurfId(int turfId);
}
