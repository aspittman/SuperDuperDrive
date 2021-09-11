package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping(value = {"/", "/login"})
    public String renderLoginPage() {
        return "login";
    }

    @GetMapping("/result")
    public String renderResultPage(@ModelAttribute("users") Users users, Model model) {
        model.addAttribute("users", users);
        return "result";
    }

}
