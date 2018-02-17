package com.FineDiary.json.JsonRegister;

public class PersonToRegisterEntity {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String lastname;
    private int mobile;
    private String school;
    private String group;//номер или название класса


    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getName(){
        return name;
}
    public String getSurname(){
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getMobile() {
        return mobile;
    }

    public String getSchool() {
        return school;
    }

    public String getGroup() {
        return group;
    }
}
