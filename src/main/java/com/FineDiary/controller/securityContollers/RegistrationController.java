package com.FineDiary.controller.securityContollers;


import com.FineDiary.entity.User;
import com.FineDiary.global.Constants;
import com.FineDiary.json.JsonRegister.PersonToRegisterEntity;
import com.FineDiary.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@Controller
public class RegistrationController {

    private UserService service;


@RequestMapping(value = "/auth/register", method = RequestMethod.POST, produces = Constants.MimeTypes.UTF_8_PLAIN_TEXT)
@ResponseBody
    public String registrationPage (@RequestHeader(value = CONTENT_TYPE)String contentTupe,
                                    @RequestBody String body,
                                    HttpServletResponse response){

    try {
        User user = new User();
        PersonToRegisterEntity newUser;
        try {
            newUser = new ObjectMapper().readValue(body, PersonToRegisterEntity.class);
        }catch (IOException e){
            response.setStatus(402);
            response.setHeader("headers","\"Content-Type\":\"application/json\"");
            return "{\"info\":\"Invalid data format\"}";
        }

        //check for unique email
        User checkUser = service.findByEmail(newUser.getEmail());
        if (checkUser != null){
            if (checkUser.getEmail().equals(newUser.getEmail()));
            throw new AuthenticationException();
        }

        user.setId(Integer.MAX_VALUE);
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setName(newUser.getName());
        user.setLastName(newUser.getSurname());
        user.setRole(String.valueOf(user));

        //because email sends for too long
        //new Thread(() -> mailSender.sendEmail(user)).start();

        response.setStatus(200);
        response.setHeader("headers","{\"Content-Type\":\"application/json\"}");

        return "{\"info\":\"New User Registered!\"}";
    }catch (AuthenticationException e){
        response.setStatus(401);
        response.setHeader("headers", "{\"Content-Type\":\"application/json\"}");
        return "{\"info\":\"Email is already in use!\"}";
    }



}



}
