package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE subjects (subjectId INTEGER NOT NULL, classId INTEGER NOT NULL, teacherId INTEGER NOT NULL);

@Entity
@Table(name = "subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "subjectId")
    private Long subjectId;

    @Column(name = "classId")
    private Long classId;

    @Column(name = "teacherId")
    private Long teacherId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
