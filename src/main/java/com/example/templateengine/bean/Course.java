package com.example.templateengine.bean;

public class Course {

    //课程名称
    private String course_name_cn;
    //英文名称
    private String course_name_en;
    //课程编号
    private String course_id;
    //学分
    private int credit;
    //总学时
    private int period;
    //实验/上机学时
    private String practice_hour;
    //课程类别
    private String obligatory;
    //适用专业
    private String discipline;
    //执笔人
    private String author;
    //审核人
    private String reviewer;
    //先修课程
    private String precondition;

    public String getCourse_name_cn() {
        return course_name_cn;
    }

    public void setCourse_name_cn(String course_name_cn) {
        this.course_name_cn = course_name_cn;
    }

    public String getCourse_name_en() {
        return course_name_en;
    }

    public void setCourse_name_en(String course_name_en) {
        this.course_name_en = course_name_en;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getPractice_hour() {
        return practice_hour;
    }

    public void setPractice_hour(String practice_hour) {
        this.practice_hour = practice_hour;
    }

    public String getObligatory() {
        return obligatory;
    }

    public void setObligatory(String obligatory) {
        this.obligatory = obligatory;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getPrecondition() {
        return precondition;
    }

    public void setPrecondition(String precondition) {
        this.precondition = precondition;
    }
}
