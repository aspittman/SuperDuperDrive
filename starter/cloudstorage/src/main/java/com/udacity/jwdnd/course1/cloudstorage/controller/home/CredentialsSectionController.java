package com.udacity.jwdnd.course1.cloudstorage.controller.home;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CredentialsSectionController {

//    @GetMapping("/home/credentials")
//    public String listAllNotes(Model model) {
//        model.addAttribute("notes", noteService.displayNotes());
//        return "home";
//    }
//
//    @PostMapping("/home/credentials")
//    public String insertCreatedNotes(@ModelAttribute("notes") Notes notes, Model model) {
//        model.addAttribute("notes", noteService.insertNotes(notes));
//        return "home";
//    }
}
