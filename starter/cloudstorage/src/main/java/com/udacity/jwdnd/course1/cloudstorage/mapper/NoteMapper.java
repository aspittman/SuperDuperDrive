package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT * from NOTES")
    List<Notes> findAll();

    @Select("SELECT * from NOTES WHERE userid=#{userId}")
    List<Notes> findById(long id);

    @Insert("INSERT into NOTES(notetitle,notedescription,userid) VALUES(#{noteTitle},#{noteDescription},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    Integer insertNoteData(Notes notes);

    @Delete("DELETE from NOTES WHERE userid=#{userId}")
    Integer deleteById(long id);
}
