package com.udacity.jwdnd.course1.cloudstorage.controller.home;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.home.credentials.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.home.files.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import com.udacity.jwdnd.course1.cloudstorage.services.home.notes.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileSectionController {

    private final UserService userService;
    private final FileService fileService;
    private final NoteService noteService;
    private final CredentialService credentialService;

    @Autowired
    public FileSectionController(UserService userService, FileService fileService, NoteService noteService, CredentialService credentialService) {
        this.fileService = fileService;
        this.userService = userService;
        this.noteService = noteService;
        this.credentialService = credentialService;
    }

    @GetMapping("/home")
    public String listUploadedFiles(Model model, Authentication auth) {
        String identifyUser = auth.getPrincipal().toString();
        model.addAttribute("files", fileService.displayFileList(userService.getUserId(identifyUser)));
        model.addAttribute("notes", noteService.displayNotesList());
        model.addAttribute("credentials", credentialService.displayCredentialsList());
        return "home";
    }

    @PostMapping("/home")
    public String handleFileUpload(@RequestParam("fileUpload") MultipartFile file, @ModelAttribute("notes") Notes notes,
                                   @ModelAttribute("credentials") Credentials credentials, Model model, Authentication auth,
                                   RedirectAttributes redirectAttributes) {

        if(file.getOriginalFilename() != null) {
            String identifyUser = auth.getPrincipal().toString();
            fileService.insertFiles(file, userService.getUserId(identifyUser));
            redirectAttributes.addFlashAttribute("dialog",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");
        }

        if(notes.getNoteTitle() != null) {
            noteService.insertNotes(notes);
            model.addAttribute("notes", notes);
            redirectAttributes.addFlashAttribute("dialog",
                    "You successfully created " + notes.getNoteTitle() + "!");
        }

        if(credentials.getUsername() != null) {
            credentialService.insertCredentials(credentials);
            model.addAttribute("credentials", credentials);
            redirectAttributes.addFlashAttribute("dialog",
                    "You successfully saved " + credentials.getUsername() + "'s credentials!");
        }

        return "redirect:/home";
    }

    @DeleteMapping("/home/{id}")
    public String deleteUploadedFiles(@PathVariable("id") String id, Model model) {
            model.addAttribute("deleteFiles", fileService.deleteFiles(Integer.parseInt(id)));

        return "home";
    }
}
