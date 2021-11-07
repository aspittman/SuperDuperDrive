package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import com.udacity.jwdnd.course1.cloudstorage.services.home.files.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final FileService fileService;

    @Autowired
    public LoginController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping()
    public String renderLoginPage() {
        return "/login";
    }

    @PostMapping()
    public String establishUserLogin(@ModelAttribute Users users, Model model) {
        model.addAttribute("username", fileService.getUserId(users.getUserId()));
        return "/login";
    }
}

