package main.java.entities;

import javax.persistence.*;

import main.java.entities.enums.noteType;

import java.util.Date;


/**
 * Created by Romio on 01.04.2017.
 */

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column (name = "noteID")
    private Integer noteId;

    @Column (name = "noteType")
    private noteType noteType;

    @Column(name = "userID")
    private Integer userId;

    @Column(name = "commentText")
    private String commentText;

    @Column(name = "dateTime")
    private Date dateTime;


    //Getters

    public Integer getId() {
        return id;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public noteType getNoteType() {
        return noteType;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public Date getDateTime() {
        return dateTime;
    }

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public void setNoteType(noteType noteType) {
        this.noteType = noteType;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}


