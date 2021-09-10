package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * from USERS")
    List<Users> findAll();

    @Select("SELECT * from USERS WHERE userid=#{userId}")
    Users findById(long id);

    @Insert("INSERT into USERS(firstname,lastname,username,password) VALUES(#{firstName},#{lastName},#{username},#{password})")
    Integer insertUserData(Users users);

    @Insert("INSERT into USERS(userid,firstname,lastname) VALUES(#{userId},#{firstName},#{lastName})")
    Integer insertTwo(Users users);

    @Delete("DELETE from USERS WHERE userid=#{userId}")
    Integer deleteById(long id);

}
