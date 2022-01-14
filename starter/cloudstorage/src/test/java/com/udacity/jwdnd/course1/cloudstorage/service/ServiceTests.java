package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import com.udacity.jwdnd.course1.cloudstorage.services.home.credentials.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.home.files.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.home.notes.NoteService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTests {

    @Autowired
    UserService userService;

    @Autowired
    FileService fileService;

    @Autowired
    NoteService noteService;

    @Autowired
    CredentialService credentialService;

    @Test
    public void userCRUDTests() {
     //   note and credential service currently not working
     //   fileService.deleteFiles(80);
        noteService.deleteNotes(95);
        credentialService.deleteCredentials(60);
    }
}
