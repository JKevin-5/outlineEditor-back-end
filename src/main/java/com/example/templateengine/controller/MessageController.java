package com.example.templateengine.controller;

import com.example.templateengine.bean.Message;
import com.example.templateengine.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageMapper messageMapper;

    //查看该收件人的信息
    @RequestMapping("/getMessages/{recevier}")
    public List<Message> getMassage(@PathVariable("recevier") String recevier){
        return messageMapper.getMessageByRecevier(recevier);
    }

    //新建信息
    @RequestMapping("/newMessage")
    public int newMessage(@RequestBody Message message){
        return messageMapper.insertMessage(message);
    }
}
