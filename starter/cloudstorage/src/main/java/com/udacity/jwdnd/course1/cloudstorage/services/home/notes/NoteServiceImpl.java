package com.udacity.jwdnd.course1.cloudstorage.services.home.notes;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.home.notes.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteMapper noteMapper;

    @Override
    public List<Notes> displayNotesList() {
        return noteMapper.findAll();
    }

    @Override
    public void insertNotes(Notes notes) {

        String noteTitle = notes.getNoteTitle();
        String noteDescription = notes.getNoteDescription();

        Notes notesModel = new Notes(noteTitle, noteDescription, 12);
        noteMapper.insertNoteData(notesModel);
    }

    @Override
    public Integer deleteNotes(long id) {
        return 0;
    }
}
