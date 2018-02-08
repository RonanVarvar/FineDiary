package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE studentInfo (studentId INTEGER NOT NULL, healthId INTEGER NOT NULL, archiveNumber TEXT NOT NULL);

@Entity
@Table(name = "studentInfo")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "studentId")
    private int studentId;

    @Column(name = "healthId")
    private Long healthId;

    @Column(name = "archiveNumber")
    private String archiveNumber;

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

    public Long getHealthId() {
        return healthId;
    }

    public void setHealthId(Long healthId) {
        this.healthId = healthId;
    }

    public String getArchiveNumber() {
        return archiveNumber;
    }

    public void setArchiveNumber(String archiveNumber) {
        this.archiveNumber = archiveNumber;
    }
}
