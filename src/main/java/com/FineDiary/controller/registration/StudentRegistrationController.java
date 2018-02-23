package com.FineDiary.controller.registration;

import com.FineDiary.entity.Students;
import com.FineDiary.global.Constants;
import com.FineDiary.json.JsonRegister.PersonToRegisterEntity;
import com.FineDiary.json.JsonRegister.StudentToRegisterEntity;
import com.FineDiary.service.MailService;
import com.FineDiary.service.StudentService;
import com.FineDiary.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;


@Controller
public class StudentRegistrationController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private MailService mailSender;

    @RequestMapping(value = "/auth/register/student", method = RequestMethod.POST, produces = Constants.MimeTypes.UTF_8_PLAIN_TEXT)
    @ResponseBody
    public String registrationPageStudent(@RequestHeader(value = CONTENT_TYPE) String contentType,
                                          @RequestBody String body,
                                          HttpServletResponse response){
        try {
            Students student  = new Students();
            StudentToRegisterEntity newStudent;
            try {
                newStudent = new ObjectMapper().readValue(body,StudentToRegisterEntity.class);
            }catch (IOException e){
                response.setStatus(402);
                response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");
                return "{\"info\":\"Wrong data format for student!\"}";
            }
            Students checkerStudent = studentService.findByEmail(newStudent.getEmail());
            if (checkerStudent != null){
                if (checkerStudent.getEmail().equals(newStudent.getEmail()))
                    throw new AuthenticationException();
            }
            student.setId(Integer.MAX_VALUE);//cant be null and cant be a number that is already registered
            student.setEmail(newStudent.getEmail());
            student.setPassword(newStudent.getPassword());
            student.setName(newStudent.getName());
            student.setPatronymic(newStudent.getPatronymic());
            student.setLastName(newStudent.getLastname());
            student.setAdress(newStudent.getAdress());
            student.setBirthday(newStudent.getBirthday());
            student.setSex(newStudent.getSex());
            student.setMobile(newStudent.getMobile());//problem don't read mobile
            student.setSchool(newStudent.getSchool());
            student.setClassNumber(newStudent.getClassNumber());
            student.setParent1Mobile(newStudent.getParent1phone());
            student.setParent1Name(newStudent.getParent1name());
            student.setParent1Patronymic(newStudent.getParent1patronymic());
            student.setParent1Surname(newStudent.getParent1surname());
            student.setParent2Mobile(newStudent.getParent2phone());
            student.setParent2Name(newStudent.getParent2name());
            student.setParent2Patronymic(newStudent.getParent2patronymic());
            student.setParent2Surname(newStudent.getParent2surname());//add classteacher
            studentService.create(student);
/*

"email":"duav6969@gmail.com",
	"password":"passwordforstudent",
	"name":"studentname",
	"patronymic":"studentpatronymic",
	"lastname":"studentlastname",
	"sex":"sex",
	"adress":"adress",
	"birthday":"birthday",
	"mobile":"0637252152",
	"parent1name":"parent1name",
	"parent1patronymic":"parent1patronymic",
	"parent1surname":"parent1surname",
	"parent1phone":"66699966",
	"parent2name":"parent2name",
	"parent2patronymic":"parent2patronymic",
	"parent2surname":"parent2surname",
	"parent2phone":"14144141",
	"school":"5",
	"classNumber":"256"


 */

            //because email sends for too long
            new Thread(() -> mailSender.sendEmail(student)).start();


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
