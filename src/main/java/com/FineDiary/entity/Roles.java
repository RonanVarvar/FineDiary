package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE roles (id INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, role VARCHAR(15) NOT NULL);

@Entity
@Table(name = "roles")
public class Roles {
    private Byte id;
    private String role;

    /* Setters */
    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    /* Getters */
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Byte getId() {
        return id;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    /* Constructors */
    public Roles() {

    }

    public Roles(String role) {
        this.role = role;
    }
}
