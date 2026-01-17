package com.turfmanagement.controller;

import com.turfmanagement.model.Review;
import com.turfmanagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
    private com.turfmanagement.service.ReviewService reviewService = new com.turfmanagement.service.impl.ReviewServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int turfId = Integer.parseInt(request.getParameter("turfId"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        String comment = request.getParameter("comment");

        Review review = new Review();
        review.setUserId(user.getId());
        review.setTurfId(turfId);
        review.setRating(rating);
        review.setComment(comment);
        review.setReviewDate(new Date());

        if (reviewService.addReview(review)) {
            response.sendRedirect("turf?action=view&id=" + turfId);
        } else {
            response.sendRedirect("turf?action=view&id=" + turfId + "&error=Review failed");
        }
    }
}
