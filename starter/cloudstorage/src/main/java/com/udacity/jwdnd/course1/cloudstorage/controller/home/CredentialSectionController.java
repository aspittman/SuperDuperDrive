package com.udacity.jwdnd.course1.cloudstorage.controller.home;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.home.credentials.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.home.notes.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CredentialSectionController {

    private final CredentialService credentialService;

    @Autowired
    public CredentialSectionController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @GetMapping("/home/credentials")
    public String listOfCredentials(Model model) {
        model.addAttribute("notes", credentialService.displayCredentialsList());
        return "home";
    }

    @PostMapping("/home/credentials")
    public String uploadUserCredentials(@ModelAttribute("credentials") Credentials credentials,
                                        Model model, RedirectAttributes redirectAttributes) {
        credentialService.insertCredentials(credentials);
        model.addAttribute("credentials", credentials);
        redirectAttributes.addFlashAttribute("dialog",
                "You successfully saved " + credentials.getUsername() + " 's credentials!");
        return "redirect:/home";
    }
}
