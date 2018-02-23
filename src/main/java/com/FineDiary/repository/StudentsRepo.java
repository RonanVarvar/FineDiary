package com.FineDiary.repository;

import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher;
import com.FineDiary.entity.Teacher2School;
import com.FineDiary.entity.User;
import com.FineDiary.json.JsonRegister.StudentToRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepo extends JpaRepository<Students,Integer>{

    @Query("select e from Students e")
    List<Students> findAll(String name);
    Students findByEmail(String name);
    Students findById(int id);
    Students deleteById(int id);
}
