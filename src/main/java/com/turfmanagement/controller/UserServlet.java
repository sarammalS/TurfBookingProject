package com.turfmanagement.controller;

import com.turfmanagement.model.User;
import com.turfmanagement.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private com.turfmanagement.service.UserService userService = new com.turfmanagement.service.impl.UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("register".equals(action)) {
            register(request, response);
        } else if ("login".equals(action)) {
            login(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("logout".equals(action)) {
            logout(request, response);
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(PasswordUtil.hashPassword(request.getParameter("password")));
        user.setEmail(request.getParameter("email"));
        user.setRole("USER");

        if (userService.register(user)) {
            response.sendRedirect("jsp/login.jsp");
        } else {
            response.sendRedirect("jsp/register.jsp?error=Registration failed");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        User user = userService.login(username, pass);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("jsp/dashboard.jsp");
        } else {
            response.sendRedirect("jsp/login.jsp?error=Invalid credentials");
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("jsp/login.jsp");
    }
}
