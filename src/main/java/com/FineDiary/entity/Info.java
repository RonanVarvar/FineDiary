package com.FineDiary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//CREATE TABLE info (userId INTEGER NOT NULL, name VARCHAR(15), surname VARCHAR(15) NOT NULL, patronymic VARCHAR(15), gender CHAR(1) NOT NULL, birthday VARCHAR(11) NOT NULL, phoneNumber VARCHAR(13) NOT NULL);

@Entity
@Table(name = "info")
public class Info {
    private Long userId;
    private String name;
    private String surname;
    private String patronymic;
    private Character gender;
    private String birthday;
    private String phoneNumber;

    /* Setters */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /* Getters */
    @Column(name = "userId")
    public Long getUserId() {
        return userId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    /* 'M' = male, 'F' = female */
    @Column(name = "gender")
    public Character getGender() {
        return gender;
    }

    /* SQLite has no type like DATETIME so
     * I use String to avoid unexpected behaviour */
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /* Constructor */
    public Info() {

    }

    public Info(Long userId, String name, String surname, String patronymic,
                Character gender, String birthday, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }
}
