package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NotesMapper {

    @Select("SELECT * FROM NOTES WHERE noteid = #{noteId}")
    List<Notes> findAllNotes();

    @Insert("INSERT into NOTES(notetitle,notedescription) VALUES(#{noteTitle}, #{noteDescription})")
    void insertNotes(Notes notes);

    @Update("update NOTES set notetitle=#{noteTitle},noteescription=#{notedescription}, where noteid=#{noteid}")
    void updateNotes(Notes notes);

    @Delete("DELETE FROM NOTES WHERE noteid =#{noteId}")
    void deleteNotes(int id);
}
