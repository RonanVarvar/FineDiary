package com.FineDiary.service;

import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher;
import com.FineDiary.entity.Teacher2School;
import com.FineDiary.repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentService {

    @Autowired
    private StudentsRepo studentsRepo;

    @Override
    public List<Students> findAllByTeacher(Teacher teacher) {
        return studentsRepo.findAll();
    }

    @Override
    public Students findStudentById(Integer id) {
        return studentsRepo.findOne(id);
    }

    @Override
    public Students create(Students students) {
        return studentsRepo.save(students);
    }

    @Override
    public Students findByEmail(String email) {
        return studentsRepo.findByEmail(email);
    }

    @Override
    public void deleteStudent(int id) {

    }
}


