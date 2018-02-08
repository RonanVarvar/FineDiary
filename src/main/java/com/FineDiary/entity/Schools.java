package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE schools (id INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, name TEXT NOT NULL, address TEXT NOT NULL);

@Entity
@Table(name = "schools")
public class Schools {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
