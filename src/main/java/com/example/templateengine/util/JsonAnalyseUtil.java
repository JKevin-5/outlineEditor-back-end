package com.example.templateengine.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.templateengine.bean.Course;
import org.apache.poi.xwpf.usermodel.*;

import java.util.ArrayList;
import java.util.List;

public class JsonAnalyseUtil {
    /*
    * 功能介绍：解析json包 返回doc
    * */
    public static XWPFDocument DocBuilder(JSONArray a){

        XWPFDocument document = new XWPFDocument();

        for(int i=0;i<a.size();i++){
            String type = a.getJSONObject(i).getString("type");

            //主标题
            if(type.equals("title")){

                String content = a.getJSONObject(i).getString("content");
                XWPFParagraph title = document.createParagraph();
                title = DocStyleUtil.setTittleStyle(title,content,"SimSun",18);
            }

            //副标题
            if (type.equals("subhead")){

                String content = a.getJSONObject(i).getString("content");
                XWPFParagraph subhead = document.createParagraph();
                DocStyleUtil.setSubHeadStyle(subhead,content,"SimSun",14);
            }

            //次级标题（第三级）
            if (type.equals("thirdhead")){

                String content = a.getJSONObject(i).getString("content");
                XWPFParagraph thirdhead = document.createParagraph();
                DocStyleUtil.setThirdHeadStyle(thirdhead,315,content,"SimSun",12);
            }


            //段落
            if (type.equals("paragraph")){

                String content = a.getJSONObject(i).getString("content");
                if(content!=null&&content.contains("\n")){
                    String[] array=content.split("\n");
                    for (int j=0;j<array.length;j++){
                        XWPFParagraph paragraph = document.createParagraph();
                        paragraph=DocStyleUtil.setParagraphStyle(paragraph,418,array[j],"SimSun",11);
                    }
                }else {
                    XWPFParagraph paragraph = document.createParagraph();
                    paragraph=DocStyleUtil.setParagraphStyle(paragraph,418,content,"SimSun",11);
                }
            }

            /*
            * 循环表格
            * ps:未加上表格备注
            * */
            if (type.equals("able")){

                List<String[]> list = new ArrayList<String[]>();
                JSONArray array = a.getJSONObject(i).getJSONArray("content");
                for(int j=0;j<array.size();j++){
                    JSONArray array1 = array.getJSONArray(j);
                    String[] s = new String[array1.size()];
                    for(int k=0;k<array1.size();k++){
                        s[k] = array1.getString(k);
                    }
                    list.add(s);
                }

                XWPFTable table = document.createTable(list.size(),list.get(0).length);
                table.setTableAlignment(TableRowAlign.CENTER);
                //table.setWidth(11849);
                DocStyleUtil.setTableStyle(table,list);
            }

            //课程信息表
            if(type.equals("fixedTable")){
                //Json字符串转javabean
                String content = a.getJSONObject(i).getString("content");
                Course course = JSONObject.parseObject(content, Course.class);
                XWPFTable table = document.createTable(6,4);
                DocStyleUtil.setCourseInfoStyle(table,course);
            }

            //循环表格（new）
            if(type.equals("table")){

                //表格注释
                String content = a.getJSONObject(i).getJSONObject("content").getString("tablenote");
                XWPFParagraph tablenote = document.createParagraph();
                DocStyleUtil.setTableNoteStyle(tablenote,content,"SimSun",11);

                //表头
                JSONArray header = a.getJSONObject(i).getJSONObject("content").getJSONArray("header");
                //表身
                JSONArray data = a.getJSONObject(i).getJSONObject("content").getJSONArray("data");
                //创建表格
                XWPFTable table = document.createTable(data.size()+1,header.size());
                DocStyleUtil.setNormalTableStyle(table,header,data);

            }
        }

        return document;
    }
}
