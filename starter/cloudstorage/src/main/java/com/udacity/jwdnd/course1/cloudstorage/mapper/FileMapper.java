package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    //basic skeleton of what sql file saving should be like
    @Select("SELECT * from FILES")
    List<Files> findAll();

    @Select("SELECT * from FILES WHERE userid=#{userId}")
    Files findById(long id);

    @Insert("INSERT into FILES(filename,contenttype,filesize,userid,filedata) VALUES(#{fileName},#{contentType},#{fileSize},#{userId},#{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insertFileData(Files files);

    @Delete("DELETE from FILES WHERE userid=#{userId}")
    int deleteById(long id);
}
