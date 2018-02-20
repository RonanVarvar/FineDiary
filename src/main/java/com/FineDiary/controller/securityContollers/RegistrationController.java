package com.FineDiary.controller.securityContollers;


import com.FineDiary.entity.User;
import com.FineDiary.global.Constants;
import com.FineDiary.json.JsonRegister.PersonToRegisterEntity;
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
public class RegistrationController {

    @Autowired
    private UserService service;


    //@RequestMapping(value = "/auth/register", method = RequestMethod.POST, produces = Constants.MimeTypes.UTF_8_PLAIN_TEXT)
    @PostMapping(value = "/auth/register")
    @ResponseBody
    public String registrationPage(@RequestHeader(value = CONTENT_TYPE) String contentType,
                                   @RequestBody String body,
                                   HttpServletResponse response) {
        try {
            User user = new User();
            PersonToRegisterEntity newUser;
            try {
                newUser = new ObjectMapper().readValue(body, PersonToRegisterEntity.class);
            } catch (IOException e) {
                response.setStatus(402);
                response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");
                return "{\"info\":\"Wrong data format!\"}";
            }

            //check for unique email
            User checkerUser = service.findByEmail(newUser.getEmail());
            if (checkerUser != null) {
                if (checkerUser.getEmail().equals(newUser.getEmail()))
                    throw new AuthenticationException();
            }
            /*
            Ученик (с родителями)
{
"name":"d",
"patronymic":"d",
"birthday":"15.02.2018",
"phone":"f",
"surname":"d",
"sex":"female",
"adress":"",
"parent1name":"d",
"parent1patronymic":"d",
"parent1surname":"d",
"parent1phone":"d",
"parent2name":"d",
"parent2patronymic":"d",
"parent2surname":"d",
"parent2phone":"d"}
Учитель
{
"name":"e",
"patronymic":"e",
"surname":"e",
"subject":"e",
"myclass":"e",
"classes":"e",
"formMaster":true,
"birthday":"15.02.2018",
"phone":"e"
}             */



            user.setId(Integer.MAX_VALUE);//cant be null and cant be a number that is already registered
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setName(newUser.getName());
            user.setPatronymic(newUser.getSurname());
            user.setLastName(newUser.getLastName());//пока заглушки
            user.setRole(newUser.getRole());//
            service.create(user);//
            // TODO добавить еще школу , либо еще класс - если учитель

//            //because email sends for too long
//            new Thread(() -> mailSender.sendEmail(user)).start();


            response.setStatus(200);
            response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");

            return "{\"info\":\"New User Registered!\"}";
        } catch (AuthenticationException e) {
            response.setStatus(401);
            response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");
            return "{\"info\":\"Email is already in use!\"}";
        }
    }



}
