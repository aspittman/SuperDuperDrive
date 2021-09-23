package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.model.Users;

import java.util.List;

public interface UserService {

    List<Users> displayUserList();

    Boolean isUsernameAvailable(String username);

    int insertUserSignupData(Users users);

    int deleteUserSignupData(long id);
}
