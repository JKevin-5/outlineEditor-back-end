package com.example.templateengine.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.templateengine.bean.user;

import com.example.templateengine.bean.Template;
import com.example.templateengine.mapper.TemplateMapper;
import com.example.templateengine.mapper.UserMapper;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "模板相关接口")
@RestController
public class TemplateController {

    @Autowired
    TemplateMapper templateMapper;


    //查看所有模板
    @RequestMapping("/showTemplates")
    public List<Template> showDemo() { return templateMapper.getAllTemplates();}

    //查找模板
    @GetMapping("/getTemplate/{id}")
    public JSONObject getTemplate(@PathVariable("id") int id){
        Template template = templateMapper.getTemplateById(id);
        JSONObject json = new JSONObject();
        json.put("id",template.getId());
        json.put("date",template.getDate());
        json.put("remark",template.getRemark());
        //string转json对象
        JSONObject content = JSON.parseObject(template.getContent());
        json.put("content",content);
        return json;
    }

    //删除模板
    @RequestMapping("/deleteTemplate/{id}")
    public int delTemplate(@PathVariable("id") int id){
        return templateMapper.deleteTemplateById(id);
    }

    //插入新模板
    @PostMapping("/insertTemplate")
    public int insertTemplate(@RequestBody Template template){
        return templateMapper.insertTemplates(template);
    }

    //获取当前表格自增id
    @RequestMapping("/autoIdByTemplate")
    public int autoId(){
        return templateMapper.selectAutoid();
    }

    //更新模板
    @RequestMapping("/updateTemplate")
    public int updateTemplate(@RequestBody Template template){
        return templateMapper.updateTemplate(template);
    }



}
