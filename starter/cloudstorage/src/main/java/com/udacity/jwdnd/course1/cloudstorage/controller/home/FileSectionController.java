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

    @GetMapping("/home")
    public String listUploadedFiles(Model model) {
        model.addAttribute("files", fileService.displayFileList());
        return "home";
    }

    @PostMapping("/home")
    public String handleFileUpload(@RequestParam("fileUpload") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        fileService.insertFiles(file);
        redirectAttributes.addFlashAttribute("dialog",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/home";
    }

    @PostMapping("/home/{id}")
    public String deleteFiles(@PathVariable("id") String id,
                              @RequestParam("fileUpload") MultipartFile file, Model model) {
        if(!file.isEmpty()) {
            model.addAttribute("deleteFiles", userService.deleteUserSignupData(Integer.parseInt(id)));
        }
        return "/home";
    }
}
