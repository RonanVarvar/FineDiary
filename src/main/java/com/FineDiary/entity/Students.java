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

        @Column(name = "ROLE",nullable = false)
        private String role;

        @Column(name = "BIRTHDAY" ,nullable = false)
        private String birthday;

        @Column(name = "SEX", nullable = false)
        private String sex;

        @Column(name = "ADRESS")
        private String adress;

        @Column(name = "PARENT1NAME" , nullable = false)
        private String parent1Name;

        @Column(name = "PARENT1PATRONYMIC", nullable = false)
        private String parent1Patronymic;

        @Column(name = "PARENT1SURNAME", nullable = false)
        private String parent1Surname;

        @Column(name = "PARENT1MOBILE", nullable = false )
        private int parent1Mobile;

        @Column(name = "PARENT2NAME" , nullable = true)
        private String parent2Name;

        @Column(name = "PARENT2PATRONYMIC", nullable = true)
        private String parent2Patronymic;

        @Column(name = "PARENT2SURNAME", nullable = true)
        private String parent2Surname;

        @Column(name = "PARENT2MOBILE", nullable = true  )
        private int parent2Mobile;


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
        public String getPasswordDecoded(){
            byte[] decoded = Base64.getDecoder().decode(password);
            String str = new String(decoded, StandardCharsets.UTF_8);
            return str;
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

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public String getParent1Name() {
            return parent1Name;
        }

        public void setParent1Name(String parent1Name) {
            this.parent1Name = parent1Name;
        }

        public String getParent1Patronymic() {
            return parent1Patronymic;
        }

        public void setParent1Patronymic(String parent1Patronymic) {
            this.parent1Patronymic = parent1Patronymic;
        }

        public String getParent1Surname() {
            return parent1Surname;
        }

        public void setParent1Surname(String parent1Surname) {
            this.parent1Surname = parent1Surname;
        }

        public int getParent1Mobile() {
            return parent1Mobile;
        }

        public void setParent1Mobile(int parent1Mobile) {
            this.parent1Mobile = parent1Mobile;
        }

        public String getParent2Name() {
            return parent2Name;
        }

        public void setParent2Name(String parent2Name) {
            this.parent2Name = parent2Name;
        }

        public String getParent2Patronymic() {
            return parent2Patronymic;
        }

        public void setParent2Patronymic(String parent2Patronymic) {
            this.parent2Patronymic = parent2Patronymic;
        }

        public String getParent2Surname() {
            return parent2Surname;
        }

        public void setParent2Surname(String parent2Surname) {
            this.parent2Surname = parent2Surname;
        }

        public int getParent2Mobile() {
            return parent2Mobile;
        }

        public void setParent2Mobile(int parent2Mobile) {
            this.parent2Mobile = parent2Mobile;
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
