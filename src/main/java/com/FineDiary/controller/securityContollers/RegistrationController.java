package com.FineDiary.controller.securityContollers;


import com.FineDiary.config.MailSender;
import com.FineDiary.entity.User;
import com.FineDiary.global.Constants;
import com.FineDiary.json.JsonRegister.PersonToRegisterEntity;
import com.FineDiary.service.MailService;
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

    @Autowired
    private MailService mailSender;


    @RequestMapping(value = "/auth/register", method = RequestMethod.POST, produces = Constants.MimeTypes.UTF_8_PLAIN_TEXT)
   // @PostMapping(value = "/auth/register")
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

            user.setId(Integer.MAX_VALUE);//cant be null and cant be a number that is already registered
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setName(newUser.getName());
            user.setPatronymic(newUser.getPatronymic());
            user.setLastName(newUser.getLastname());//пока заглушки
            user.setRole(newUser.getRole());
            user.setAdress(newUser.getAdress());
            user.setBirthday(newUser.getBirthday());
            user.setSex(newUser.getSex());
            user.setMobile(newUser.getMobile());
            user.setParent1Mobile(newUser.getParent1phone());
            user.setParent1Name(newUser.getParent1name());
            user.setParent1Patronymic(newUser.getParent1patronymic());
            user.setParent1Surname(newUser.getParent1surname());
            user.setParent2Mobile(newUser.getParent2phone());
            user.setParent2Name(newUser.getParent2name());
            user.setParent2Patronymic(newUser.getParent2patronymic());
            user.setParent2Surname(newUser.getParent2surname());





            service.create(user);//
            // TODO добавить еще школу , либо еще класс - если учитель

           //because email sends for too long
           new Thread(() -> mailSender.sendEmail(user)).start();


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
