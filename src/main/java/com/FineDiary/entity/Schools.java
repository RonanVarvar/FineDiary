package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE schools (id INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, name TEXT NOT NULL, address TEXT NOT NULL);

@Entity
@Table(name = "schools")
public class Schools {
    private Long id;
    private String name;
    private String address;

    public Schools() {
    }

    /* Setters */
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /* Getters */
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    /* Constructor */
    public Schools(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
