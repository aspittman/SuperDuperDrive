package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UsersMapper {
    @Select("SELECT * FROM USERS WHERE username = #{userName} AND password = #{password}")
    Users findUserByNameAndPassword(Users users);

    @Select("SELECT * FROM USERS WHERE username = #{userName}")
    String queryUserName(String users);

    @Select("SELECT * FROM USERS WHERE userid = #{userId}")
    List<Users> findAllUsers();

    @Insert({"INSERT into USERS(username,salt,password,firstname,lastname) VALUES(#{userName},#{salt},#{password),#{firstName},#{lastName}"})
    void insertUsers(Users users);

    @Update("update USERS set username=#{userName},salt=#{salt},password=#{password},firstname=#{firstName},lastname=#{lastName} where userid=#{userId}")
    void updateUsers(Files files);

    @Delete("DELETE FROM USERS WHERE userid =#{userId}")
    void deleteUsers(int id);
}
