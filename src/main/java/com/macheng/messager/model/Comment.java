package com.macheng.messager.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

public class Comment {
    private long id;
    private String message;
    private Date createdDate;
    private String author;

    public Comment() {

    }

    public Comment(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.createdDate = new Date();
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
