package com.FineDiary.json.JsonRegister;

public class StudentToRegisterEntity {
    private String email;
    private String password;
    private String name;
    private String patronymic;
    private String lastname;
    private String sex;
    private String adress;
    private String birthday;
    private String mobile;
    private String parent1name;
    private String parent1patronymic;
    private String parent1surname;
    private String parent1phone;
    private String parent2name;
    private String parent2patronymic;
    private String parent2surname;
    private String parent2phone;
    private String school;
    private String classNumber;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSex() {
        return sex;
    }

    public String getAdress() {
        return adress;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public String getParent1name() {
        return parent1name;
    }

    public String getParent1patronymic() {
        return parent1patronymic;
    }

    public String getParent1surname() {
        return parent1surname;
    }

    public String getParent1phone() {
        return parent1phone;
    }

    public String getParent2name() {
        return parent2name;
    }

    public String getParent2patronymic() {
        return parent2patronymic;
    }

    public String getParent2surname() {
        return parent2surname;
    }

    public String getParent2phone() {
        return parent2phone;
    }

    public String getSchool() {
        return school;
    }

    public String getClassNumber() {
        return classNumber;
    }

    @Override
    public String toString() {
        return "StudentToRegisterEntity{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", lastname='" + lastname + '\'' +
                ", sex='" + sex + '\'' +
                ", adress='" + adress + '\'' +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                ", parent1name='" + parent1name + '\'' +
                ", parent1patronymic='" + parent1patronymic + '\'' +
                ", parent1surname='" + parent1surname + '\'' +
                ", parent1phone='" + parent1phone + '\'' +
                ", parent2name='" + parent2name + '\'' +
                ", parent2patronymic='" + parent2patronymic + '\'' +
                ", parent2surname='" + parent2surname + '\'' +
                ", parent2phone='" + parent2phone + '\'' +
                ", school='" + school + '\'' +
                ", classNumber='" + classNumber + '\'' +
                '}';
    }
}
