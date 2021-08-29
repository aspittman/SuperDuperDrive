package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoteMapper {

    //basic skeleton of what sql note saving should be like
    //copy and paste from filemapper edit when ready
    @Select("SELECT * from NOTES")
    List<Notes> findAll();

    @Select("SELECT * from NOTES WHERE userid=#{userId}")
    Notes findById(long id);

    @Insert("INSERT into NOTES(noteid,notetitle,notedescription,userid) VALUES(#{noteId},#{noteTitle},#{noteDescription},#{userId})")
    int insertFileData(Notes notes);

    @Delete("DELETE from NOTES WHERE userid=#{userId}")
    int deleteById(long id);
}
