package com.FineDiary.service;

import com.FineDiary.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher findTeacherById(Integer id);
    Teacher create(Teacher teacher);
    Teacher findByEmail(String name);
    List<Teacher>findAll();

    void updateTeacher(String password, String email);
    // void deleteTeacher(int id);

}
