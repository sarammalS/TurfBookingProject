package com.turfmanagement.controller;

import com.turfmanagement.model.Turf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/turf")
public class TurfServlet extends HttpServlet {
    private com.turfmanagement.service.TurfService turfService = new com.turfmanagement.service.impl.TurfServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || "list".equals(action)) {
            List<Turf> turfs = turfService.getAllTurfs();
            request.setAttribute("turfs", turfs);
            request.getRequestDispatcher("jsp/turf-list.jsp").forward(request, response);
        } else if ("view".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Turf turf = turfService.getTurfById(id);
            request.setAttribute("turf", turf);
            request.getRequestDispatcher("jsp/turf-detail.jsp").forward(request, response);
        }
    }
}
