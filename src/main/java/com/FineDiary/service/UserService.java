package com.FineDiary.service;

import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher;
import com.FineDiary.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService{
    User findUserById(Integer id);
    //User findUserByEmail(String email);
    User create(User user);
    //List<String> findByName(String name);
    User findByEmail(String name);


    List<User> findAll();
    void updateUser(String password, String email);



    void deleteUser(int id);
}