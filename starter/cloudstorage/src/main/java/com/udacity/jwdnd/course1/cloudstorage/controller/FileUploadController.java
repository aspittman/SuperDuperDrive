package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.filestorage.StorageService;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    UserMapper userMapper;

    @GetMapping("/home")
    public String listUploadedFiles(Model model) {
        model.addAttribute("files", userMapper.findAll());
        return "home";
    }

    @PostMapping("/home")
    public String handleFileUpload(@RequestParam("fileUpload") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("dialog",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/home";
    }

    @DeleteMapping("/home")
    public String deleteFiles(Model model) {
        model.addAttribute("deleteFiles", userMapper.deleteById(3));
        return "/home";
    }

//    @PostMapping("/home")
//    public String deleteFiles(@ModelAttribute("users") Users users, Model model) {
//        model.addAttribute("users", users);
//        userMapper.deleteALL(users);
//        return "redirect:/home";
//    }

//    @DeleteMapping
//    @PostMapping("/home")
//    public String insertUserSignup(@ModelAttribute("users") Users users, Model model) {
//        model.addAttribute("users", users);
//        userMapper.insertUserSignupData(users);
//        return "redirect:/home";
//    }
}
