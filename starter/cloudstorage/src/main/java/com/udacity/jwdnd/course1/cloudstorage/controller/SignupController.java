package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import com.udacity.jwdnd.course1.cloudstorage.services.HashService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignupController {

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String signUpPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUpRequest(Users users, Model model) {

        String username = users.getUserName();

        if (userService.findByUserName(username) == null) {

            model.addAttribute("firstname", users.getFirstName());
            model.addAttribute("lastname", users.getLastName());
            model.addAttribute("username", users.getUserName());
            model.addAttribute("password", users.getPassword());
            userService.register(users);
            return "login";
        } else {
            model.addAttribute("msg", "Registration failed");
            // Registration fails to jump to the error page
            return "result";
        }
    }
}
