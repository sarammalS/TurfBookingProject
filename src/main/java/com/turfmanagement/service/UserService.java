package com.turfmanagement.service;

import com.turfmanagement.model.User;

public interface UserService {
    boolean register(User user);

    User login(String username, String password);
}
