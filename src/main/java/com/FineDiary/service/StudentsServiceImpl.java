package com.FineDiary.service;

import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher2School;
import com.FineDiary.repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentService{

    @Autowired
    private StudentsRepo studentsRepo;

    @Override
    public List<Students> findAllByTeacher(Teacher2School teacher) {
        return null;
    }

    @Override
    public Students findStudentById(Integer id) {
        return null;
    }

    @Override
    public Students create(Students students) {
        return studentsRepo.save(students);
    }

    @Override
    public void deleteById(int id) {

    }
}
