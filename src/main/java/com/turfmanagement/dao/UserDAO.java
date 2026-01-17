package com.turfmanagement.dao;

import com.turfmanagement.model.User;

public interface UserDAO {
    boolean registerUser(User user);

    User loginUser(String username);

    User getUserById(int id);
}
