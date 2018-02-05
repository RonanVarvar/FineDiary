package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE subjects (subjectId INTEGER NOT NULL, classId INTEGER NOT NULL, teacherId INTEGER NOT NULL);

@Entity
@Table(name = "subjects")
public class Subjects {
    private Long subjectId;
    private Long classId;
    private Long teacherId;

    /* Setters */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /* Getters */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "subjectId")
    public Long getSubjectId() {
        return subjectId;
    }

    @Column(name = "classId")
    public Long getClassId() {
        return classId;
    }

    @Column(name = "teacherId")
    public Long getTeacherId() {
        return teacherId;
    }

    /* Constructor */

    public Subjects() {

    }

    public Subjects(Long subjectId, Long classId, Long teacherId) {
        this.subjectId = subjectId;
        this.classId = classId;
        this.teacherId = teacherId;
    }
}
