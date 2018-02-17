package com.FineDiary.repository;

import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher2School;
import com.FineDiary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepo extends JpaRepository<Students,Integer>{

    List<Students> findAllBy(Teacher2School teacher2School);
}
