package com.FineDiary.entity;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Set;


@Entity
@Table(name = "TEACHERS")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "PASSWORD",nullable = false)
    private String password;

    @Column(name = "EMAIL",nullable = false,unique = true)
    private String email;

    @Column (name = "NAME",nullable = false)
    private String name;

    @Column(name = "PATRONYMIC",nullable = false)
    private String patronymic;

    @Column(name = "LASTNAME",nullable = false)
    private String lastName;

    @Column(name = "SCHOOL",nullable = false)
    private String school;

    @Column(name = "MYCLASS", nullable = true)
    private String myClass;

    @Column(name = "CLASSES", nullable = true)
    private String classesList;

    @Column(name = "FORMMASTER", nullable = false)
    private boolean formMaster;

    @Column(name = "BIRTHDAY" ,nullable = false)
    private String birthday;

    @Column(name = "MOBILE",nullable = false)
    private String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordDecoded(){
        byte[] decoded = Base64.getDecoder().decode(password);
        String str = new String(decoded, StandardCharsets.UTF_8);
        return str;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMyClass() {
        return myClass;
    }

    public void setMyClass(String myClass) {
        this.myClass = myClass;
    }

    public String getClassesList() {
        return classesList;
    }

    public void setClassesList(String classesList) {
        this.classesList = classesList;
    }

    public boolean isFormMaster() {
        return formMaster;
    }

    public void setFormMaster(boolean formMaster) {
        this.formMaster = formMaster;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "SUDENT_ID", nullable = false, referencedColumnName = "Id")
//    private Set<Students> students;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", lastName='" + lastName + '\'' +
                ", school='" + school + '\'' +
                ", myClass='" + myClass + '\'' +
                ", classesList='" + classesList + '\'' +
                ", formMaster=" + formMaster +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
