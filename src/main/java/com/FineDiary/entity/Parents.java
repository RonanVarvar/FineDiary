package com.FineDiary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//CREATE TABLE parents (studentId INTEGER NOT NULL, fatherId INTEGER, motherId INTEGER);

@Entity
@Table(name = "parents")
public class Parents {
    private Long studentId;
    private Long fatherId;
    private Long motherId;

    /* Setters */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public void setMotherId(Long motherId) {
        this.motherId = motherId;
    }

    /* Getters */
    @Column(name = "studentId")
    public Long getStudentId() {
        return studentId;
    }

    @Column(name = "fatherId")
    public Long getFatherId() {
        return fatherId;
    }

    @Column(name = "motherId")
    public Long getMotherId() {
        return motherId;
    }

    /* Constructor */
    public Parents() {

    }

    public Parents(Long studentId, Long fatherId, Long motherId) {
        this.studentId = studentId;
        this.fatherId = fatherId;
        this.motherId = motherId;
    }
}
