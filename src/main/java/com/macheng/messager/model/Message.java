package com.macheng.messager.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class Message {
    private long id;
    private String message;
    private Date createdDate;
    private String author;
    private Map<Long, Comment> comments;

    public Message() {
    }

    public Message(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.createdDate = new Date();
        this.author = author;
        this.comments = new HashMap<Long, Comment>();
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlTransient
    public Map<Long, Comment> getComments() {
        return  comments;
    }

    public void setComments(Map<Long, Comment> comments)  {
        this.comments = comments;
    }

}
