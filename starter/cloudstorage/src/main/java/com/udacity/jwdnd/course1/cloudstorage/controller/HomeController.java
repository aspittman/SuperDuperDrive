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

import java.util.Objects;

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
    public String listAllDrives(Model model, Authentication auth) {
        String identifyUser = auth.getPrincipal().toString();
        model.addAttribute("files", fileService.displayFileList(userService.getUserId(identifyUser)));
        model.addAttribute("notes", noteService.displayNotesList(userService.getUserId(identifyUser)));
        model.addAttribute("credentials", credentialService.displayCredentialsList(userService.getUserId(identifyUser)));
        return "home";
    }

    @PostMapping("/home")
    public String handleDriveUploads(@RequestParam(value = "fileUpload", required = false) MultipartFile files,
                                   @ModelAttribute(value = "note-title") Notes notes,
                                     @ModelAttribute(value = "note") Notes secondNotes,
                                   @ModelAttribute(value = "credential-url") Credentials credentials,
                                     @ModelAttribute(value = "credential") Credentials secondCredentials,
                                   Authentication auth, RedirectAttributes redirectAttributes) {

        String identifyUser = auth.getPrincipal().toString();
//        Integer noteCheck = noteService.findNote(11);
//        Integer credentialCheck = credentialService.findCredential(11);

        if (files != null) {
            fileService.insertFiles(files, userService.getUserId(identifyUser));
            redirectAttributes.addFlashAttribute("dialog",
                    "You successfully uploaded " + files.getOriginalFilename() + "!");
        } else if (secondNotes.getNoteDescription() != null) {
            noteService.insertNotes(notes, userService.getUserId(identifyUser));
            redirectAttributes.addFlashAttribute("dialog",
                    "You successfully created " + notes.getNoteTitle() + "!");
//        } else if () {
//            noteService.updateNotes(secondNotes, userService.getUserId(identifyUser));
//            redirectAttributes.addFlashAttribute("dialog",
//                    secondNotes.getNoteTitle() + " successfully updated!");
        } else if (secondCredentials.getUsername() != null) {
            credentialService.insertCredentials(credentials, userService.getUserId(identifyUser));
            redirectAttributes.addFlashAttribute("dialog",
                    "You successfully saved " + credentials.getUsername() + "'s credentials!");
//        } else if (Objects.equals(credentials.getCredentialId(), credentialCheck)) {
//            credentialService.updateCredentials(secondCredentials, userService.getUserId(identifyUser));
//            redirectAttributes.addFlashAttribute("dialog",
//                    secondCredentials.getUsername() + " successfully updated!");
    }
        return "redirect:/home";
    }

    @GetMapping("/home/view/{fileId}")
    @ResponseBody
    public ResponseEntity<byte[]> displayFile(@PathVariable(required = false, name ="fileId") Integer fileId) {

        Files selectedFile = fileService.getFileById(fileId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .body(selectedFile.getFileData());
    }

    @GetMapping("/home/file/{fileId}")
    public String deleteFiles(@PathVariable(required = false, name = "fileId") Integer fileId,
                                      RedirectAttributes redirectAttributes) {

            fileService.deleteFiles(fileId);
            redirectAttributes.addFlashAttribute("dialog", "File successfully deleted");

        return "redirect:/home";
    }

    @GetMapping("/home/note/{noteId}")
    public String deleteNotes(@PathVariable(required = false, name = "noteId") Integer noteId,
                                      RedirectAttributes redirectAttributes) {

        noteService.deleteNotes(noteId);
        redirectAttributes.addFlashAttribute("dialog", "Note successfully deleted");

        return "redirect:/home";
    }

    @GetMapping("/home/credential/{credentialId}")
    public String deleteCredentials(@PathVariable(required = false, name = "credentialId") Integer credentialId,
                                      RedirectAttributes redirectAttributes) {

        credentialService.deleteCredentials(credentialId);
        redirectAttributes.addFlashAttribute("dialog", "Credential successfully deleted");

        return "redirect:/home";
    }
}
