package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CredentialsMapper {

    @Select("SELECT * FROM CREDENTIALS where credentialid = #{credentialId}")
    List<Credentials> findAllCredentials();

    @Insert("INSERT into CREDENTIALS(url,username,password) VALUES(#{url}, #{userName}, #{password)")
    void insertCredentials(Credentials credentials);

    @Update("UPDATE CREDENTIALS SET url=#{url},username=#{username},key=#{key},password=#{password} where credentialid=#{credentialId}")
    int updateCredentials(Credentials credentials);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialid =#{credentialId}")
    void deleteCredentials(int id);
}
