package com.example.templateengine.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.templateengine.bean.Course;
import org.apache.poi.xwpf.usermodel.*;

import java.util.List;

public class DocStyleUtil {

    /*
    * 功能说明：设置主标题(默认加粗）
    * @time：2020.3.12
    * @author：kevinjiang
    * @param paragraph
    * @param content 内容
    * @param family 字体
    * @param size   字号
    * */
    public static XWPFParagraph setTittleStyle(XWPFParagraph paragraph,String content,String family,int size){
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        //段前
        paragraph.setSpacingBeforeLines(100);
        //段后
        paragraph.setSpacingAfterLines(100);
        //行距
        paragraph.setSpacingBetween(1.25);
        //create title
        XWPFRun run=paragraph.createRun();
        run.setText(content);
        run.setFontFamily(family);
        run.setFontSize(size);
        run.setBold(true);
        return paragraph;
    }

    /*
    * 功能说明：设置副标题（默认加粗）
    * @time：2020.3.12
    * @author: kevinjiang
    * @param paragraph
    * @param content 内容
    * @param family 字体
    * @param size   字号
    * */
    public static void setSubHeadStyle(XWPFParagraph paragraph,String content,String family,int size){
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        paragraph.setSpacingBeforeLines(50);
        paragraph.setSpacingAfterLines(50);
        paragraph.setSpacingBetween(1.25);
        //create subhead
        XWPFRun run=paragraph.createRun();
        run.setText(content);
        run.setFontFamily(family);
        run.setFontSize(size);
        run.setBold(true);
    }

    /*
    * 功能说明：设置段落
    * @time：2020.3.12
    * @author：kevinjiang
    * @param intention 首行缩进 单位为twip
    * @param content 内容
    * @param family 字体
    * @param size 字号
    * */
    public static XWPFParagraph setParagraphStyle(XWPFParagraph paragraph,int intention,String content,String family,int size){
        paragraph.setIndentationFirstLine(intention);
        paragraph.setSpacingBetween(1.25);

        XWPFRun run =paragraph.createRun();
        run.setText(content);
        run.setFontFamily(family);
        run.setFontSize(size);

        return paragraph;
    };

    /*
    * 功能说明：设置次级标题
    * @time: 2020.3.16
    * @author: kevinjiang
    * @param
    * */
    public static void setThirdHeadStyle(XWPFParagraph paragraph,int intention,String content,String family,int size){
        paragraph.setIndentationFirstLine(intention);

        //create paragraph
        XWPFRun run =paragraph.createRun();
        run.setText(content);
        run.setFontFamily(family);
        run.setFontSize(size);
        run.setBold(true);
    }

    /*
    * 功能说明：设置表格注释
    * @time: 2020.3.16
    * @author: kevinjiang
    * @param
    * */
    public static void setTableNoteStyle(XWPFParagraph paragraph,String content,String family,int size){
        paragraph.setSpacingBeforeLines(100);
        paragraph.setAlignment(ParagraphAlignment.CENTER);


        //create paragraph
        XWPFRun run =paragraph.createRun();
        run.setText(content);
        run.setFontFamily(family);
        run.setFontSize(size);
    }

    /*
    * 功能说明：设置表格 一般NxN的表格
    * @time：2020.3.15
    * @author: kevinjiang
    * @param XWPFTable
    * @param list 表格数据
    * */
    public static void setTableStyle(XWPFTable table, List<String[]> list){
        for(int i = 0;i<list.size();i++){
            String [] s =list.get(i);
            for(int j =0;j<s.length;j++){
                /*XWPFParagraph p1 = table.getRow(i).getCell(j).addParagraph();
                p1.setAlignment(ParagraphAlignment.CENTER);
                XWPFRun r1 = p1.createRun();
                r1.setText(s[j]);
                r1.setBold(true);*/
                table.getRow(i).getCell(j).setText(s[j]);
            }
        }

    }

    /*
    * 功能说明：设置课程信息表格
    * @time：2020.4.29
    * @author: kevinjiang
    * @param: XWPFTable
    * @param: Course
    * */
    public static void setCourseInfoStyle(XWPFTable table, Course course){
        String [][] str ={
                {"课程编号",course.getCourse_id(),"学    分",course.getCredit()+""},
                {"总 学 时",course.getPeriod()+"","实验/上机学时",course.getPractice_hour()},
                {"课程名称",course.getCourse_name_cn(),"英文名称",course.getCourse_name_en()},
                {"课程类别",course.getObligatory(),"适用专业",course.getDiscipline()},
                {"执 笔 人",course.getAuthor(),"审 核 人",course.getReviewer()},
                {"先修课程",course.getPrecondition(),course.getPrecondition(),course.getPrecondition()}
        };
        for(int i=0;i<6;i++){
            //设置行高,单位：5=0.01cm
            table.getRow(i).setHeight(395);
            for(int j=0;j<4;j++){
                TableStyle.setCellText(table.getRow(i).getCell(j),str[i][j],null,ParagraphAlignment.CENTER,XWPFTableCell.XWPFVertAlign.CENTER,11,true);
            }
        }

            TableStyle.mergeCellsHorizontal(table,5,1,3);
            //设置表格长度,twips,16cm
            table.setWidth(9040);
            table.setTableAlignment(TableRowAlign.CENTER);
    }

    /*
    * 功能说明: 设置普通循环表格
    * @time: 2020.5.01
    * @author: kevinjiang
    * @param: XWPFTable
    * @param: tablenote 表格注释
    * @param: header 表头
    * @param: data 表身
    * */
    public static void setNormalTableStyle(XWPFTable table, JSONArray header, JSONArray data){

        //设置表格长度,twips,16cm
        table.setWidth(9040);
        table.setTableAlignment(TableRowAlign.CENTER);

        //填充表头，固定为居中、加粗、宋体、五号
        for(int i=0;i<header.size();i++){
            TableStyle.setCellText(table.getRow(0).getCell(i),header.getString(i),null,ParagraphAlignment.CENTER,XWPFTableCell.XWPFVertAlign.CENTER,11,true);
        }

        //填充表身，默认为靠左、正常、宋体、五号
        for(int i=1;i<data.size()+1;i++){
            for(int j=0;j<header.size();j++){
                if(data.getJSONArray(i-1).getString(j).length()<=47){
                    TableStyle.setCellText(table.getRow(i).getCell(j),data.getJSONArray(i-1).getString(j),null,ParagraphAlignment.CENTER,XWPFTableCell.XWPFVertAlign.CENTER,11,false);
                }else {
                    TableStyle.setCellText(table.getRow(i).getCell(j),data.getJSONArray(i-1).getString(j),null,ParagraphAlignment.LEFT,XWPFTableCell.XWPFVertAlign.TOP,11,false);
                }

            }
        }

    }

}
