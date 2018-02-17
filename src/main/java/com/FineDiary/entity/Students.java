package com.FineDiary.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


    @Entity
    @Table(name = "STUDENTS")
    public class Students {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;


        @Column(name = "EMAIL",nullable = false,unique = true)
        private String email;

        @Column(name = "PASSWORD", nullable = false,unique = true)
        private String password;

        @Column (name = "NAME",nullable = false)
        private String name;

        @Column(name = "LASTNAME",nullable = false)
        private String lastName;

        @Column(name = "SURNAME",nullable = false)
        private String surrName;

        @Column(name = "SCHOOL", nullable = false)
        private String school;

        @Column(name = "CLASS", nullable = false)
        private String studentClass;

        @Column(name = "STUDENTMOBILE", nullable = false)
        private int studentMobile;

        //Getters and Setters


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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

        public String getStudentClass() {
            return studentClass;
        }

        public void setStudentClass(String studentClass) {
            this.studentClass = studentClass;
        }

        public int getStudentMobile() {
            return studentMobile;
        }

        public void setStudentMobile(int studentMobile) {
            this.studentMobile = studentMobile;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }

}
