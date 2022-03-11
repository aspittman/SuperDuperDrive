package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
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
public class HomeController {

    private final UserService userService;
    private final FileService fileService;
    private final NoteService noteService;
    private final CredentialService credentialService;

    @Autowired
    public HomeController(UserService userService, FileService fileService, NoteService noteService, CredentialService credentialService) {
        this.fileService = fileService;
        this.userService = userService;
        this.noteService = noteService;
        this.credentialService = credentialService;
    }

    @GetMapping("/home")
    public String listUploadedFiles(Model model, Authentication auth) {
        String identifyUser = auth.getPrincipal().toString();
        model.addAttribute("files", fileService.displayFileList(userService.getUserId(identifyUser)));
        model.addAttribute("notes", noteService.displayNotesList(userService.getUserId(identifyUser)));
        model.addAttribute("credentials", credentialService.displayCredentialsList(userService.getUserId(identifyUser)));
        return "home";
    }

    @PostMapping("/home")
    public String handleFileUpload(@RequestParam(value = "fileUpload", required = false) MultipartFile files,
                                   @ModelAttribute(value = "note-title") Notes notes,
                                   @ModelAttribute(value = "url") Credentials credentials,
                                   Authentication auth, RedirectAttributes redirectAttributes) {

        String identifyUser = auth.getPrincipal().toString();

        if (files != null) {
            fileService.insertFiles(files, userService.getUserId(identifyUser));
            redirectAttributes.addFlashAttribute("dialog",
                    "You successfully uploaded " + files.getOriginalFilename() + "!");
        } else {
            noteService.insertNotes(notes, userService.getUserId(identifyUser));
            redirectAttributes.addFlashAttribute("dialog",
                    "You successfully created " + notes.getNoteTitle() + "!");

            credentialService.insertCredentials(credentials, userService.getUserId(identifyUser));
            redirectAttributes.addFlashAttribute("dialog",
                    "You successfully saved " + credentials.getUsername() + "'s credentials!");
        }
        return "redirect:/home";
    }

    @GetMapping("/home/{fileName}/{fileId}")
    @ResponseBody
    public ResponseEntity<byte[]> displayFile(@PathVariable(required = false, name ="fileId") Integer fileId) {

        Files selectedFile = fileService.getFileById(fileId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .body(selectedFile.getFileData());
    }

    @GetMapping(value = {"/home/{fileId}", "/home/{noteId}", "/home/{credentialId}"})
    public String deleteUploadedFiles(@PathVariable(required = false, name = "fileId") Integer fileId,
                                      @PathVariable(required = false, name = "noteId") Integer noteId,
                                      @PathVariable(required = false, name = "credentialId") Integer credentialId,
                                      RedirectAttributes redirectAttributes) {

        if (fileId != null) {
            fileService.deleteFiles(fileId);
            redirectAttributes.addFlashAttribute("dialog", "File successfully deleted");
        }
        if (noteId != null) {
            noteService.deleteNotes(noteId);
            redirectAttributes.addFlashAttribute("dialog", "Note successfully deleted");
        }
        if (credentialId != null) {
            credentialService.deleteCredentials(credentialId);
            redirectAttributes.addFlashAttribute("dialog", "Credential successfully deleted");
        }
        return "redirect:/home";
    }
}
