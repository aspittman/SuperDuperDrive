package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UsersMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    HashService hashService;

    public void register(Users users) {
        String password = users.getPassword();


        hashService.getHashedValue(password, users.getSalt());
        usersMapper.insertUsers(users);
    }

    public Users login(Users users) {
        return usersMapper.findUserByNameAndPassword(users);
    }


    public String findByUserName(String users) {
        return usersMapper.queryUserName(users);
    }
}
