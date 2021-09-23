package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import com.udacity.jwdnd.course1.cloudstorage.services.security.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final HashService hashService;

    public UserServiceImpl(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    @Override
    public List<Users> displayUserList() {
        return userMapper.findAll();
    }

    @Override
    public Boolean isUsernameAvailable(String username) {
            return userMapper.getUser(username) == null;
    }

    @Override
    public int insertUserSignupData(Users users) {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(users.getPassword(), encodedSalt);
        return userMapper.insertUserData(new Users(null, users.getUsername(), encodedSalt, hashedPassword, users.getFirstName(), users.getLastName()));
    }

    @Override
    public int deleteUserSignupData(long id) {
        return userMapper.deleteById(id);
    }


}
