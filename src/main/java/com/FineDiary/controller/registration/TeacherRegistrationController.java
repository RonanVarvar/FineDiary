package com.FineDiary.controller.registration;

import com.FineDiary.config.MailSender;
import com.FineDiary.entity.Students;
import com.FineDiary.entity.Teacher;
import com.FineDiary.global.Constants;
import com.FineDiary.json.JsonRegister.PersonToRegisterEntity;
import com.FineDiary.json.JsonRegister.TeacherToRegistrationEntity;
import com.FineDiary.service.MailService;
import com.FineDiary.service.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@Controller
public class TeacherRegistrationController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    MailService mailService;



    @RequestMapping(value = "/auth/register/teacher", method = RequestMethod.POST, produces = Constants.MimeTypes.UTF_8_PLAIN_TEXT)
    @ResponseBody
    public String registrationPageStudent(@RequestHeader(value = CONTENT_TYPE) String contentType,
                                      @RequestBody String body,
                                      HttpServletResponse response){
    try {
        Teacher teacher = new Teacher();
        TeacherToRegistrationEntity newTeacher;
        try {
            newTeacher = new ObjectMapper().readValue(body,TeacherToRegistrationEntity.class);
        }catch (IOException e){
            response.setStatus(402);
            response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");
            return "{\"info\":\"Wrong data format for teacher!\"}";
        }
        Teacher checkerTeacher = teacherService.findByEmail(newTeacher.getEmail());
        if (checkerTeacher != null){
            if (checkerTeacher.getEmail().equals(newTeacher.getEmail()))
                throw new AuthenticationException();
        }
        teacher.setId(Integer.MAX_VALUE);//cant be null and cant be a number that is already registered
        teacher.setEmail(newTeacher.getEmail());
        teacher.setPassword(newTeacher.getPassword());
        teacher.setName(newTeacher.getName());
        teacher.setPatronymic(newTeacher.getPatronymic());
        teacher.setLastName(newTeacher.getLastname());
        teacher.setBirthday(newTeacher.getBirthday());
        teacher.setMobile(newTeacher.getMobile());
        teacher.setSchool(newTeacher.getSchool());
        teacher.setFormMaster(newTeacher.isFormMaster());//если true то заполнить поле с классом
        if (newTeacher.isFormMaster() == true){
        teacher.setMyClass(newTeacher.getClassNumber());} //♠
        teacherService.create(teacher);

        //because email sends for too long
        new Thread(() -> mailService.sendEmail(teacher)).start();


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
