package com.FineDiary.controller.register;


import com.FineDiary.entity.Teacher;
import com.FineDiary.json.JsonRegister.PersonToRegisterEntity;
import com.FineDiary.service.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import javax.naming.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RegisterTeacher {
    @Autowired
    private TeacherService service;

    @PostMapping(value = "/auth/register/teacher")
    @ResponseBody
    public String registrationPageForTeacher(@RequestHeader(value = CONTENT_TYPE) String contentType,
                                             @RequestBody String body,
                                             HttpServletResponse response) {

        try {
            Teacher teacher = new Teacher();
            PersonToRegisterEntity newUser;
            try {
                newUser = new ObjectMapper().readValue(body, PersonToRegisterEntity.class);
            } catch (IOException e) {
                response.setStatus(402);
                response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");
                return "{\"info\":\"Wrong data format!\"}";
            }

            Teacher checkTeacher = service.findByEmail(newUser.getEmail());
            if (checkTeacher != null) {
                if (checkTeacher.getEmail().equals(newUser.getEmail()))
                    throw new AuthenticationException();
            }
            teacher.setId(Integer.MAX_VALUE);
            teacher.setEmail(newUser.getEmail());
            teacher.setPassword(newUser.getPassword());
            teacher.setName(newUser.getName());
            teacher.setLastName(newUser.getLastname());
            teacher.setSchool(newUser.getSchool());
            teacher.setOwnClass(newUser.getGroup());
            service.create(teacher);


         //   new Thread(() -> mailSender.sendEmail(teacher)).start();//отправляем мейл что учитель зарегистрировался

            response.setStatus(200);
            response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");

            return "{\"info\":\"New Teacher Registered!\"}";
        } catch (AuthenticationException e) {
            response.setStatus(401);
            response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");
            return "{\"info\":\"Email is already in use!\"}";
        }
    }
}







