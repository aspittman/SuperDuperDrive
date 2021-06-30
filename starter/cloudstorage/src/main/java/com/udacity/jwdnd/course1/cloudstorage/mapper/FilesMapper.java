package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FilesMapper {

    @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
    List<Files> findAllFiles();

    @Insert("INSERT into FILES(filename,contenttype,filesize,filedata) VALUES(#{fileName}, #{contentType}, #{fileSize), #{fileData}")
    void insertFiles(Files files);

    @Update("UPDATE FILES set filename=#{fileName},contenttype=#{contentType}, filesize=#{fileSize}, filedata=#{fileData} where fileid=#{fileId}")
    void updateFiles(Files files);

    @Delete("DELETE FROM FILES WHERE fileId =#{fileId}")
    void deleteFiles(int id);
}
