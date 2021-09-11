package com.udacity.jwdnd.course1.cloudstorage.controller.home;

import com.udacity.jwdnd.course1.cloudstorage.services.home.files.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileSectionController {

    private final FileService fileService;
    private final UserService userService;

    @Autowired
    public FileSectionController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @GetMapping("/home/files")
    public String listUploadedFiles(Model model) {
        model.addAttribute("files", fileService.displayFileList());
        return "home";
    }

    @PostMapping("/home/files")
    public String handleFileUpload(@RequestParam("fileUpload") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        fileService.store(file);
        redirectAttributes.addFlashAttribute("dialog",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/home";
    }

    @PostMapping("/home/deleted")
    public String deleteFiles(Model model) {
        model.addAttribute("deleteFiles", userService.deleteUserSignupData(10));
        return "redirect:/home";
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
