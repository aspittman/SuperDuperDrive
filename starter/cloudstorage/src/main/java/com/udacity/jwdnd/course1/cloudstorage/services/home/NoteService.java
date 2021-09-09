package com.udacity.jwdnd.course1.cloudstorage.services.home;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;

import java.util.List;

public interface NoteService {

    List<Notes> displayNotes();

    void insertNotes(Notes notes);

    int deleteNotes(long id);
}
