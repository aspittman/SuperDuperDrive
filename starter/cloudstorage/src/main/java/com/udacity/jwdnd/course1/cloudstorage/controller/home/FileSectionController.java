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

    @DeleteMapping("/home")
    public String deleteUploadedFiles(@PathVariable("id") String id, Model model) {
            model.addAttribute("deleteFiles", fileService.deleteFiles(Integer.parseInt(id)));
        return "redirect:/home";
    }
}
