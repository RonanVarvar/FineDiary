package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE classes (id INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, schoolId INTEGER NOT NULL, curatorId INTEGER NOT NULL, year VARCHAR(5) NOT NULL, letter CHAR(1) NOT NULL);

@Entity
@Table(name = "classes")
public class Classes {
    private Long id;
    private Long schoolId;
    private Long curatorId;
    private Byte year;
    private Character letter;

    /* Setters */
    public void setId(Long id) {
        this.id = id;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public void setCuratorId(Long curatorId) {
        this.curatorId = curatorId;
    }

    public void setYear(Byte year) {
        this.year = year;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    /* Getters */
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "schoolId")
    public Long getSchoolId() {
        return schoolId;
    }

    @Column(name = "curatorId")
    public Long getCuratorId() {
        return curatorId;
    }

    /* Year+letter like 11-A, 6-B */
    @Column(name = "year")
    public Byte getYear() {
        return year;
    }

    @Column(name = "letter")
    public Character getLetter() {
        return letter;
    }

    /* Constructor */
    public Classes() {

    }

    public Classes(Long schoolId, Long curatorId, Byte year, Character letter) {
        this.schoolId = schoolId;
        this.curatorId = curatorId;
        this.year = year;
        this.letter = letter;
    }
}
