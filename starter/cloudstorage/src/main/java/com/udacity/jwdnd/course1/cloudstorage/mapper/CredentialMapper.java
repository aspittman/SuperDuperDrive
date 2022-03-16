package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialMapper {

    @Select("SELECT * from CREDENTIALS")
    List<Credentials> findAll();

    @Select("SELECT * from CREDENTIALS WHERE userid=#{userId}")
    List<Credentials> findByUserId(long id);

    @Select("SELECT * from NOTES WHERE credentialid=#{credentialId}")
    Credentials findCredential(long id);

    @Insert("INSERT into CREDENTIALS(url,username,key,password,userid) VALUES(#{url},#{username},#{key},#{password},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    Integer insertCredentialData(Credentials credentials);

    @Update("UPDATE CREDENTIALS SET url = #{url},username= #{username},key = #{key},password = #{password},userid = #{userid} WHERE credentialid=#{credentialId}")
    Integer updateCredentialData(Credentials credentials);

    @Delete("DELETE from CREDENTIALS WHERE credentialid=#{credentialId}")
    Integer deleteById(Integer id);
}
