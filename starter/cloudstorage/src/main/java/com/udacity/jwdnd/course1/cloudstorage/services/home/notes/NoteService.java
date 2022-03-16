package com.udacity.jwdnd.course1.cloudstorage.services.home.notes;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;

import java.util.List;

public interface NoteService {

    List<Notes> displayNotesList(Integer userId);

    Notes findNote(Integer noteId);

    void insertNotes(Notes notes, Integer userId);

    Integer updateNotes(Notes notes);

    Integer deleteNotes(Integer id);
}
