package com.example.templateengine.mapper;

import com.example.templateengine.bean.user;
import com.example.templateengine.bean.Template;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface UserMapper {

    /*
    * 功能说明：查找所有user
    * */
    @Select("select userId,name,authority from user")
    public List<user> showUsers();

    /*
    * 功能说明：通过用户Id查找user
    * */
    @Select("select userId,userName,name,authority from user where userId=#{userId}")
    public user getUserById(int userId);

    /*
    * 功能说明：通过用户name查找user
    * */
    @Select("select * from user where userName=#{userName}")
    public user getUserByName(String userName);

    /*
    * 功能说明：删除用户
    * */
    @Delete("delete from user where userId=#{userId}")
    public int deleteUserById(int userId);

    /*
    * 功能说明：更改用户密码
    * */
    @Update("update user set passWord=#{password} where userId=#{userId}")
    public int updateUser(user user);

    /*
    * 功能说明：更改用户权限
    * */
    @Update("update user set authority=#{authority} where userId=#{userId}")
    public int changeUserById(user user);

    /*
    * 功能说明：新建用户
    * */
    @Insert("insert into user(userId,userName,passWord,authority) values(#{userId},#{userName},#{passWord},#{authority})")
    public int insertUser(user user);

}
