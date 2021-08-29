package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface CredentialMapper {

    //basic skeleton of what sql credential saving should be like
    //copy and paste from filemapper edit when ready
    @Select("SELECT * from CREDENTIALS")
    List<Credentials> findAll();

    @Select("SELECT * from CREDENTIALS WHERE userid=#{userId}")
    Credentials findById(long id);

    @Insert("INSERT into CREDENTIALS(credentialid,url,username,key,password,userid) VALUES(#{credentialId},#{url},#{username},#{key},#{password},#{userId})")
    int insertFileData(Credentials credentials);

    @Delete("DELETE from CREDENTIALS WHERE userid=#{userId}")
    int deleteById(long id);
}
