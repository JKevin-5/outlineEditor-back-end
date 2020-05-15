package com.example.templateengine.mapper;

import com.example.templateengine.bean.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {

    /*
    * 功能：查找属于发件人的消息
    * */
    @Select("Select * from message where receiver=#{recevier} order by id desc")
    public List<Message> getMessageByRecevier(String recevier);

    /*
    * 功能：新建信息
    * */
    @Insert("insert into message(addresser,receiver,date,d_id,d_name,message,status) values(#{addresser},#{receiver},#{date},#{d_id},#{d_name},#{message},#{status})")
    public int insertMessage(Message message);

    /*
    * 功能：删除信息
    * */

}
