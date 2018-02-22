package com.FineDiary.service;

import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Students> findAllStudents(Students student);
    Teacher findStudentById(Integer id);
    Teacher create(Teacher students);
    Teacher findByEmail(String name);
    void deleteById(int id);
}
