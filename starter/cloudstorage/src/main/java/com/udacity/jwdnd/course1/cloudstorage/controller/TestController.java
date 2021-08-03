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
public class TestController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("users", new Users());
        return "test";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute("users") Users users, Model model) {
        model.addAttribute("users", users);
        userMapper.insertOne(users);
        return "test";
    }
}
