package com.FineDiary.service;

import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher2School;

import java.util.List;

public interface StudentService {
    List<Students> findAllByTeacher(Teacher2School teacher);
    Students findStudentById(Integer id);
    Students create(Students students);
    void deleteById(int id);
}
