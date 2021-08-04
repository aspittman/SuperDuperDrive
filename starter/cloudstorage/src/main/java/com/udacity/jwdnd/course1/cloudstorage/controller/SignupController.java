package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/signup")
    public String renderSignupPage(Model model) {
        model.addAttribute("users", new Users());
        return "signup";
    }

    @PostMapping("/signup")
    public String insertUserSignup(@ModelAttribute("users") Users users, Model model) {
        model.addAttribute("users", users);
        userMapper.insertUserSignupData(users);
        return "signup";
    }
}
