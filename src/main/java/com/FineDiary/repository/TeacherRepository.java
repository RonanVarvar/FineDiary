package com.FineDiary.repository;

import com.FineDiary.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer>{
    Teacher findByEmail(String name);

    List<Teacher> findAll();



}
