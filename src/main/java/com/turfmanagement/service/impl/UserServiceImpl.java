package com.turfmanagement.service.impl;

import com.turfmanagement.dao.UserDAO;
import com.turfmanagement.dao.impl.UserDAOImpl;
import com.turfmanagement.model.User;
import com.turfmanagement.service.UserService;
import com.turfmanagement.util.PasswordUtil;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean register(User user) {
        return userDAO.registerUser(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userDAO.loginUser(username);
        if (user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
