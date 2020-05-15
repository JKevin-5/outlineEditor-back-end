package com.example.templateengine.bean;


public class Template {
    private int id;
    private String date;
    private String remark;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        //JSONObject object = JSON.parseObject(content);
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
