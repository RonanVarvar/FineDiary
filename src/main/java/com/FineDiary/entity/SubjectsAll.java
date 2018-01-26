package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE subjectsAll (id INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, subject VARCHAR(20) NOT NULL);

@Entity
@Table(name = "subjectsAll")
public class SubjectsAll {
    private Long id;
    private String subject;

    /* Setters */
    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /* Getters */
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    /* Constructors */
    public SubjectsAll() {

    }

    public SubjectsAll(String subject) {
        this.subject = subject;
    }
}
