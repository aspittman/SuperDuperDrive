package com.udacity.jwdnd.course1.cloudstorage.services.home.notes;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.home.notes.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteMapper noteMapper;

    public NoteServiceImpl(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    @Override
    public List<Notes> displayNotesList() {
        return noteMapper.findAll();
    }

    @Override
    public void insertNotes(Notes notes, Integer userId) {

        String noteTitle = notes.getNoteTitle();
        String noteDescription = notes.getNoteDescription();

        Notes notesModel = new Notes(null, noteTitle, noteDescription, userId);
        noteMapper.insertNoteData(notesModel);
    }

    @Override
    public Integer deleteNotes(long id) {
        return noteMapper.deleteById(id);
    }
}
