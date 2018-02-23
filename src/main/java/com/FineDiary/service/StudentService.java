package com.FineDiary.service;

import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher;
import com.FineDiary.entity.Teacher2School;

import java.util.List;

public interface StudentService {
    List<Students> findAllByTeacher(Teacher teacher);
    Students findStudentById(Integer id);
    Students create(Students students);
    Students findByEmail(String name);
    void deleteStudent(int id);
}
