package com.FineDiary.json.JsonRegister;

public class TeacherToRegistrationEntity {
    private String email;
    private String password;
    private String name;
    private String patronymic;
    private String lastname;
    private String sex;
    private String birthday;
    private String mobile;
    private String school;
    private String classNumber;
    private boolean formMaster;

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

    public String getBirthday() {
        return birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public String getSchool() {
        return school;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public boolean isFormMaster() {
        return formMaster;
    }

    @Override
    public String toString() {
        return "TeacherToRegistrationEntity{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", lastname='" + lastname + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                ", school='" + school + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", formMaster=" + formMaster +
                '}';
    }
}
