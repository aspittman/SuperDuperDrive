package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * from USERS")
    List<Users> findAll();

    @Select("SELECT userid from USERS")
    List<Users> getUserId();

    @Select("SELECT * from USERS WHERE userid=#{userId}")
    Users findById(long id);

    @Insert("INSERT into USERS(firstname,lastname,username,password) VALUES(#{firstName},#{lastName},#{username},#{password})")
    int insertUserData(Users users);

    @Insert("INSERT into USERS(userid,firstname,lastname) VALUES(#{userId},#{firstName},#{lastName})")
    int insertTwo(Users users);

    @Delete("DELETE from USERS WHERE userid=#{userId}")
    int deleteById(long id);

}
