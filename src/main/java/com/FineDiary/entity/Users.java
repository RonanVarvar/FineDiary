package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE users (id INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, email VARCHAR(30) NOT NULL, password VARCHAR(30) NOT NULL, role INTEGER NOT NULL);

@Entity
@Table(name = "users")
public class Users {
    private Long id;
    private String email;
    private String password;
    private Byte role;

    /* Setters */
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    /* Getters */
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    /*
     * 0 - admin
     * 1 - teacher
     * 2 - parent
     * 3 - student
     */
    @Column(name = "role")
    public Byte getRole() {
        return role;
    }

    /* Constructor */
    public Users() {

    }

    public Users(String email, String password, Byte role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
