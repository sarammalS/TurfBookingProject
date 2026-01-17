package com.turfmanagement.controller;

import com.turfmanagement.model.Slot;
import com.turfmanagement.model.Turf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/slot")
public class SlotServlet extends HttpServlet {
    private com.turfmanagement.service.SlotService slotService = new com.turfmanagement.service.impl.SlotServiceImpl();
    private com.turfmanagement.service.TurfService turfService = new com.turfmanagement.service.impl.TurfServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int turfId = Integer.parseInt(request.getParameter("turfId"));
        Turf turf = turfService.getTurfById(turfId);
        List<Slot> slots = slotService.getAvailableSlots(turfId);

        request.setAttribute("turf", turf);
        request.setAttribute("slots", slots);
        request.getRequestDispatcher("jsp/slot-list.jsp").forward(request, response);
    }
}
