package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<Users> displayUserList() {
        return userMapper.findAll();
    }

    @Override
    public int insertUserSignupData(Users users) {
        return userMapper.insertUserData(users);
    }

    @Override
    public int deleteUserSignupData(long id) {
        return userMapper.deleteById(id);
    }


}
