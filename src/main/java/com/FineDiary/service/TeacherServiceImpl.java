package com.FineDiary.service;



import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher;
import com.FineDiary.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public List<Students> findAllStudents(Students student) {

        return null;
    }

    @Override
    public Teacher findStudentById(Integer id) {
        return null;
    }

    @Override
    public Teacher create(Teacher teacher) {
        byte[] bytes = new byte[0];
        try {
            bytes = teacher.getPassword().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String encoded = Base64.getEncoder().encodeToString(bytes);
        teacher.setPassword(encoded);
        return teacherRepository.save(teacher);
    }

    @Override
    @Transactional
    public Teacher findByEmail(String email) {
        return teacherRepository.findByEmail(email);
    }

    @Override
    public void deleteById(int id) {

    }
}
