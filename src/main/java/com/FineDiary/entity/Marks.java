package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE marks (id INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, studentId INTEGER NOT NULL, subjectId INTEGER NOT NULL, date TEXT NOT NULL, MARK INTEGER NOT NULL);

@Entity
@Table(name = "marks")
public class Marks {
    private Long id;
    private Long studentId;
    private Long subjectId;
    private String date;
    private Byte mark;

    /* Setters */
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMark(Byte mark) {
        this.mark = mark;
    }

    /* Getters */
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "studentId")
    public Long getStudentId() {
        return studentId;
    }

    @Column(name = "subjectId")
    public Long getSubjectId() {
        return subjectId;
    }

    /* SQLite has no type like DATETIME so
     * I use String to avoid unexpected behaviour */
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    /* Marks vary from 1 to 12
     * >O.M.>Also possible from 1 to 100 (for university)
     * */
    @Column(name = "mark")
    public Byte getMark() {
        return mark;
    }

    /* Constructor */
    public Marks() {

    }

    public Marks(Long studentId, Long subjectId, String date, Byte mark) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.date = date;
        this.mark = mark;
    }
}
