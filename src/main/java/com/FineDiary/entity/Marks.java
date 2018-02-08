package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE marks (id INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, studentId INTEGER NOT NULL, subjectId INTEGER NOT NULL, date TEXT NOT NULL, MARK INTEGER NOT NULL);

@Entity
@Table(name = "marks")
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "studentId")
    private int studentId;

    @Column(name = "subjectId")
    private int subjectId;

    @Column(name = "date")
    private String date;

    @Column(name = "mark")
    private Byte mark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Byte getMark() {
        return mark;
    }

    public void setMark(Byte mark) {
        this.mark = mark;
    }


}
