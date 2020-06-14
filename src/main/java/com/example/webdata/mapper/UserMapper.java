package com.example.webdata.mapper;

import com.example.webdata.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values (#{username},#{password})")
    void adduser(User user);
    @Select("select * from user where username=#{username} and password=#{password}")
    User verifyuser(String username,String password);
    @Select("select * from user where username=#{username}")
    User checkusername(String username);
    @Update("update user set token=#{token} where username=#{username}")
    void update(User verifyuser);
    @Select("select * from user ")
    List<User> getallusers();
}
