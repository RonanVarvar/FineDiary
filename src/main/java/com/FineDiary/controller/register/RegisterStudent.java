package com.FineDiary.controller.register;

import com.FineDiary.entity.Students;
import com.FineDiary.json.JsonRegister.PersonToRegisterEntity;
import com.FineDiary.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;


@Controller
public class RegisterStudent {
    @Autowired
    private StudentService service;


    @PostMapping(value = "/auth/register/student")
    @ResponseBody
    public String registrationPage(@RequestHeader(value = CONTENT_TYPE) String contentType,
                                   @RequestBody String body,
                                   HttpServletResponse response) {
        try {
            Students student = new Students();
            PersonToRegisterEntity newUser;
            try {
                newUser = new ObjectMapper().readValue(body, PersonToRegisterEntity.class);
            } catch (IOException e) {
                response.setStatus(402);
                response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");
                return "{\"info\":\"Wrong data format!\"}";
            }

            //check for unique email
            Students checkerStudent = service.findByEmail(newUser.getEmail());
            if (checkerStudent != null) {
                if (checkerStudent.getEmail().equals(newUser.getEmail()))
                    throw new AuthenticationException();
            }
            student.setId(Integer.MAX_VALUE);//cant be null and cant be a number that is already registered
            student.setEmail(newUser.getEmail());
            student.setPassword(newUser.getPassword());
            student.setName(newUser.getName());
            student.setSurrName(newUser.getSurname());
            student.setLastName(newUser.getLastname());
            service.create(student);
            // TODO добавить еще школу , либо еще класс - если учитель

//            //because email sends for too long
//            new Thread(() -> mailSender.sendEmail(user)).start();


            response.setStatus(200);
            response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");

            return "{\"info\":\"New Student Registered!\"}";
        } catch (AuthenticationException e) {
            response.setStatus(401);
            response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");
            return "{\"info\":\"Email is already in use!\"}";
        }
    }

}
