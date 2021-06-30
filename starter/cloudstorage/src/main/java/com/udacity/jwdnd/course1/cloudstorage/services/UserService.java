package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    // User registration
    void register(Users users);

    // User login
    Users login(Users users);

    // Query based on user name
    String findByUserName(String users);
}