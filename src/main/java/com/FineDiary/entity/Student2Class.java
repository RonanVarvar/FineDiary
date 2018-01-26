package com.FineDiary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//CREATE TABLE student2class (studentId INTEGER NOT NULL, classId INTEGER NOT NULL);

@Entity
@Table(name = "student2class")
public class Student2Class {
    private Long studentId;
    private Long classId;

    /* Setters */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    /* Getters */
    @Column(name = "studentId")
    public Long getStudentId() {
        return studentId;
    }

    @Column(name = "classId")
    public Long getClassId() {
        return classId;
    }

    /* Constructor */
    public Student2Class() {

    }

    public Student2Class(Long studentId, Long classId) {
        this.studentId = studentId;
        this.classId = classId;
    }
}
