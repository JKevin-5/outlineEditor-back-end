package com.example.templateengine.controller;

import com.example.templateengine.bean.user;
import com.example.templateengine.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import com.example.templateengine.util.userUtil;

import java.util.List;

@Api(tags = "用户相关接口")
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @ApiOperation("查找所有用户接口")
    @GetMapping("/showUsers")
    public List<user> show(){
        return userMapper.showUsers();
    }


    @ApiOperation("通过用户id查找用户接口")
    @GetMapping("/getUser/{id}")
    public user getUser(@PathVariable("id") int id){
        user user = userMapper.getUserById(id);
        //String recode = user.getPassWord();
        //user.setPassWord(userUtil.encryption(recode));
        return user;
    }

    @ApiOperation("通过用户名查找用户接口")
    @GetMapping("/getUserByName/{userName}")
    public user getUser(@PathVariable("userName") String userName){
        user user = userMapper.getUserByName(userName);
        String recode = user.getPassWord();
        user.setPassWord(userUtil.encryption(recode));
        return user;
    }

    @ApiIgnore
    @ApiOperation("删除用户接口")
    @DeleteMapping("/deleteUser/{id}")
    public int delUser(@PathVariable("id") int id){
        return userMapper.deleteUserById(id);
    }


    @ApiOperation("新建用户接口")
    @PostMapping("/insertUser")
    public int insertUser(@RequestBody user user){
        return userMapper.insertUser(user);
    }

    @ApiIgnore
    @ApiOperation("更改用户密码接口")
    @PostMapping("/updatePassWord")
    public int updatePassWord(@RequestBody user user){
        String recode = user.getPassWord();
        user.setPassWord(userUtil.encryption(recode));
        return userMapper.updateUser(user);
    }


    //更改用户权限
    @PostMapping("/changeAuthority")
    public int changeAuthority(@RequestBody user user){
        return userMapper.changeUserById(user);
    }

    //确认密码
    @PostMapping("/confirm")
    public int confirmUserInfo(@RequestBody user user){
        user user1 = userMapper.getUserByName(user.getUserName());
        String recode = userUtil.encryption(user.getPassWord());
        if(user1!=null&&user1.getPassWord().equals(recode)){
            return user1.getUserId();
        }else {
            return 200;
        }
    }

}
