package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE studentInfo (studentId INTEGER NOT NULL, healthId INTEGER NOT NULL, archiveNumber TEXT NOT NULL);

@Entity
@Table(name = "studentInfo")
public class StudentInfo {
    private Long studentId;
    private Long healthId;
    private String archiveNumber;

    /* Setters */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setHealthId(Long healthId) {
        this.healthId = healthId;
    }

    public void setArchiveNumber(String archiveNumber) {
        this.archiveNumber = archiveNumber;
    }

    /* Getters */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "studentId")
    public Long getStudentId() {
        return studentId;
    }

    @Column(name = "healthId")
    public Long getHealthId() {
        return healthId;
    }

    @Column(name = "archiveNumber")
    public String getArchiveNumber() {
        return archiveNumber;
    }

    /* Constructor */
    public StudentInfo() {

    }

    public StudentInfo(Long studentId, Long healthId, String archiveNumber) {
        this.studentId = studentId;
        this.healthId = healthId;
        this.archiveNumber = archiveNumber;
    }
}
