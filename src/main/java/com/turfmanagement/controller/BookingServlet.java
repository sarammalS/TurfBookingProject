package com.turfmanagement.controller;

import com.turfmanagement.model.Booking;
import com.turfmanagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    private com.turfmanagement.service.BookingService bookingService = new com.turfmanagement.service.impl.BookingServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int slotId = Integer.parseInt(request.getParameter("slotId"));

        Booking booking = new Booking();
        booking.setUserId(user.getId());
        booking.setSlotId(slotId);
        booking.setBookingDate(new Date());
        booking.setStatus("CONFIRMED");

        if (bookingService.bookSlot(user.getId(), slotId)) {
            response.sendRedirect("booking?action=list");
        } else {
            response.sendRedirect("turf?action=list&error=Booking failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            List<Booking> bookings = bookingService.getUserBookings(user.getId());
            request.setAttribute("bookings", bookings);
            request.getRequestDispatcher("jsp/dashboard.jsp").forward(request, response);
        }
    }
}
