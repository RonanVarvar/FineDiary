package com.FineDiary.entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher2school")
public class Teacher2School {
    private Long teacherId;
    private Long schoolId;

    /* Setters */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    /* Getters */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "teacherId")
    public Long getTeacherId() {
        return teacherId;
    }

    @Column(name = "schoolId")
    public Long getSchoolId() {
        return schoolId;
    }

    /* Constructor */
    public Teacher2School() {

    }

    public Teacher2School(Long teacherId, Long schoolId) {
        this.teacherId = teacherId;
        this.schoolId = schoolId;
    }
}
