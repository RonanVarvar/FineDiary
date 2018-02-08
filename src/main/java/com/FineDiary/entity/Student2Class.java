package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE student2class (studentId INTEGER NOT NULL, classId INTEGER NOT NULL);

@Entity
@Table(name = "student2class")
public class Student2Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "studentId")
    private Long studentId;

    @Column(name = "classId")
    private Long classId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}
