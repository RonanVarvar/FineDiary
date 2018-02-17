package com.FineDiary.entity;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


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

        @Column(name = "LASTNAME",nullable = false)
        private String lastName;

        @Column(name = "SURNAME",nullable = false)
        private String surrName;

        @Column(name = "SCHOOL", nullable = false)
        private String school;

        @Column(name = "CLASS", nullable = true)
        private String ownClass;

        @Column(name = "TEACHERMOBILE", nullable = false)
        private int teacherMobile;




        //Getters and Setters


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

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getSurrName() {
            return surrName;
        }

        public void setSurrName(String surrName) {
            this.surrName = surrName;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getOwnClass() {
            return ownClass;
        }

        public void setOwnClass(String ownClass) {
            this.ownClass = ownClass;
        }

        public int getTeacherMobile() {
            return teacherMobile;
        }

        public void setTeacherMobile(int teacherMobile) {
            this.teacherMobile = teacherMobile;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", school='" + school + '\'' +
                    "ownClass=" + ownClass + '\'' +
                    '}';
        }
    }

