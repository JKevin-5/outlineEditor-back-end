package com.example.templateengine.bean;

public class Message {

    private String addresser;//发件人
    private String receiver;//收件人
    private int d_id;//文档编号
    private String d_name;//文档名称
    private String message;//备注消息
    private String status;//状态
    private String date;//时间


    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getAddresser() {
        return addresser;
    }

    public void setAddresser(String addresser) {
        this.addresser = addresser;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
