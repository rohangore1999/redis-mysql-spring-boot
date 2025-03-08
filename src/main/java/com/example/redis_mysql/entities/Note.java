package com.example.redis_mysql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity // The @Entity annotation marks a class as a JPA entity, which means this class will be mapped to a table in the database. Each instance of the class will represent a row in the corresponding table.

// When you annotate a class with @Entity, JPA treats it as an object that will be persisted (stored) in a relational database. The fields of this class will map to the columns of the database table.

@Table(name="stream_note")
public class Note implements Serializable { // implements Serializable -> it will store the data as string
    @Id // The @Id annotation is used to specify the primary key of an entity.
    private String id;

    private String title;

    private String content;

    private Date addedDate;

    private boolean live = false;

    public Note(String id, String title, String content, Date addedDate, boolean live) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.addedDate = addedDate;
        this.live = live;
    }

    public Note() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
