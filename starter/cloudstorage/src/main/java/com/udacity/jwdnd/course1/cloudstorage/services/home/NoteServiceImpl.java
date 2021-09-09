package com.udacity.jwdnd.course1.cloudstorage.services.home;

import com.udacity.jwdnd.course1.cloudstorage.filestorage.StorageException;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteMapper noteMapper;

    @Override
    public List<Notes> displayNotes() {
        return noteMapper.findAll();
    }

    @Override
    public void insertNotes(Notes notes) {

        String noteTitle = notes.getNoteTitle();
        String noteDescription = notes.getNoteDescription();
        int userId = notes.getUserId();

        Notes notesModel = new Notes(noteTitle, noteDescription,12);
        noteMapper.insertNoteData(notesModel);
    }

    @Override
    public int deleteNotes(long id) {
        return 0;
    }
}
