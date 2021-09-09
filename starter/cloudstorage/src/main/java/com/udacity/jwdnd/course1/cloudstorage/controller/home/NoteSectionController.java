package com.udacity.jwdnd.course1.cloudstorage.controller.home;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.home.notes.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NoteSectionController {

    private final NoteService noteService;

    @Autowired
    public NoteSectionController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/home")
    public String listAllNotes(Model model) {
        model.addAttribute("notes", noteService.displayNotesList());
        return "home";
    }

    @PostMapping("/home")
    public String uploadCreatedNotes(Notes notes, Model model,
                                     RedirectAttributes redirectAttributes) {
        noteService.insertNotes(notes);
        model.addAttribute("notes", notes);
        redirectAttributes.addFlashAttribute("dialog",
                "You successfully created " + notes.getNoteTitle() + "!");
        return "redirect:/home";
    }
}