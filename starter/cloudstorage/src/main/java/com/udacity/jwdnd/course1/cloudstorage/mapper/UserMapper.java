package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * from USERS")
    List<Users> findAll();

    @Select("SELECT * FROM USERS WHERE username = #{username}")
    Users getUser(String username);

    @Select("SELECT * from USERS WHERE userid=#{userId}")
    Users findById(long id);

    @Insert("INSERT into USERS(username,salt,password,firstname,lastname) VALUES(#{username},#{salt},#{password},#{firstName},#{lastName})")
    Integer insertUserData(Users users);

    @Delete("DELETE from USERS WHERE userid=#{userId}")
    Integer deleteById(long id);

}
