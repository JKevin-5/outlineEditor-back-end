package com.example.templateengine.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.templateengine.bean.Document;
import com.example.templateengine.util.JsonAnalyseUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class WordTestController {


    @RequestMapping("/word")
    public void wordMaker(@RequestBody Document document, HttpServletResponse response, HttpServletRequest request) throws IOException{


        // 设置文件头：最后一个参数是设置下载文件名
        //response.setHeader("Content-Disposition", "attachment;fileName="+"word.docx");
        // 设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("application/octet-stream");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        //获取content
        JSONObject content = JSON.parseObject(document.getContent());
        JSONArray data = content.getJSONArray("data");

        //Blank Document
        XWPFDocument document1 = new XWPFDocument();
        //填充文档
        document1 = JsonAnalyseUtil.DocBuilder(data);

        //输出流，便于在servlet下载
        //ServletOutputStream out = response.getOutputStream();

        //FileOutputStream out = new FileOutputStream(new File("createdocument.docx"));

        OutputStream out = response.getOutputStream();

        document1.write(out);
        document1.close();

        out.flush();
        out.close();



    }

}
