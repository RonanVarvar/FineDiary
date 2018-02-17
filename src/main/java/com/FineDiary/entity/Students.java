package com.FineDiary.entity;

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

        @Column (name = "NAME",nullable = false)
        private String name;

        @Column(name = "LASTNAME",nullable = false)
        private String lastName;

        @Column(name = "SURNAME",nullable = false)
        private String surrName;

        //Getters and Setters
        public int getId() {
            return id;
        }

        @JoinColumn(name = "TEACHER_ID", nullable=false, referencedColumnName="Id")
        private Teacher2School teacher2School;


        public void setId(int id) {
            this.id = id;
        }


        public Teacher2School getTeacher2School() {
            return teacher2School;
        }

        public void setTeacher2School(Teacher2School teacher2School) {
            this.teacher2School = teacher2School;
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
