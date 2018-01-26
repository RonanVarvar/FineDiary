package com.FineDiary.entity;

import javax.persistence.*;

//CREATE TABLE healthGroups (id INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, name VARCHAR(15) NOT NULL);

@Entity
@Table(name = "healthGroups")
public class HealthGroups {
    private Long id;
    private String name;

    /* Setters */
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    /* Constructors */
    public HealthGroups() {

    }

    public HealthGroups(String name) {
        this.name = name;
    }
}
