package com.example.templateengine.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.templateengine.bean.Document;
import com.example.templateengine.mapper.DocumentMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "文档相关接口")
@RestController
public class DocumentController {


    @Autowired
    DocumentMapper documentMapper;

    //查看所有文档
    @RequestMapping("/getDocuments")
    public List<Document> show(){return documentMapper.getAllDocuments();}

    //查看所有文档
    @RequestMapping("/getDocuments/{userName}")
    public List<Document> getDocumentByUserName(@PathVariable("userName") String userName){
        return documentMapper.getDocumentByUserName(userName);
    }

    //查找文档
    @GetMapping("/getDocument/{id}")
    public JSONObject getDocumentById(@PathVariable("id") int id){
        Document document = documentMapper.getDocumentById(id);
        JSONObject json =new JSONObject();
        json.put("id",document.getId());
        json.put("date",document.getDate());
        json.put("name",document.getName());
        json.put("t_id",document.getT_id());
        JSONObject content = JSON.parseObject(document.getContent());
        json.put("content",content);
        json.put("status",document.getStatus());
        return json;
    }

    //删除文档
    @RequestMapping("/deleteDocument/{id}")
    public int delDocument(@PathVariable("id") int id){
        return documentMapper.deleteDocumentById(id);
    }

    //插入新文档
    @PostMapping("/insertDocument")
    public int insertDocument(@RequestBody Document document){
        return documentMapper.insertDocument(document);
    }

    //更新文档
    @RequestMapping("/updateDocument")
    public int updateDocument(@RequestBody Document document){
        return documentMapper.updateDocument(document);
    }

    //更新文档状态
    @RequestMapping("/updateStatus/{id}/{status}")
    public int updateStatus(@PathVariable("id") int id,@PathVariable("status") String status){
        return documentMapper.updateDocumentByStatus(id,status);
    }

    //获取当前表格自增id
    @RequestMapping("/autoIdByDocument")
    public int autoId(){
        return documentMapper.selectAutoid();
    }
}
