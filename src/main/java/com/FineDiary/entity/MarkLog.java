package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE markLog (markId INTEGER NOT NULL, note TEXT);

@Entity
@Table(name = "markLog")
public class MarkLog {
    private Long markId;
    private String note;

    /* Setters */
    public void setMarkId(Long markId) {
        this.markId = markId;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /* Getters */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "markId")
    public Long getMarkId() {
        return markId;
    }

    @Column(name = "note")
    public String getNote() {
        return note;
    }

    /* Constructor */
    public MarkLog() {

    }

    public MarkLog(Long markId, String note) {
        this.markId = markId;
        this.note = note;
    }
}
