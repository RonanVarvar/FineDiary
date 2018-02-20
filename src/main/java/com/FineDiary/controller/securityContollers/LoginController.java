package com.FineDiary.controller.securityContollers;

import com.FineDiary.entity.Token;
import com.FineDiary.entity.User;
import com.FineDiary.json.JsonRegister.PersonToLoginEntity;

import com.FineDiary.json.Login.LoginResponseBuilder;
import com.FineDiary.service.TokenService;
import com.FineDiary.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.FineDiary.entity.Authorization.UserRoleEnum.ADMIN;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@Controller
public class LoginController {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;


    @PostMapping(value = "/auth/login")
    @ResponseBody
    public String loginPage(@RequestHeader(value = CONTENT_TYPE) String contentType,
                            @RequestBody String body,
                            HttpServletResponse response) throws IOException , Exception {
        boolean isUser, isAdmin;
        LoginResponseBuilder builder = new LoginResponseBuilder();

        PersonToLoginEntity dataUser = new ObjectMapper().readValue(body, PersonToLoginEntity.class);

        Token newToken = new Token();
        String result;
        try {
            User user = userService.findByEmail(dataUser.getEmail());

            if (!user.getPasswordDecoded().equals(dataUser.getPassword())) {
                throw new Exception();
            }
            //check Role
            if (user.getRole().equals(ADMIN)) {
                isAdmin = true;
                isUser = false;
            } else {
                isAdmin = false;
                isUser = true;
            }
            String usrPassHash = DigestUtils.sha1Hex(user.getEmail() + user.getPassword());
            try {
                Token thisToken = tokenService.findByUserPasswordHash(usrPassHash);
                if (thisToken.getUser().getRole().equals(ADMIN)) {
                    newToken.setId(Integer.MAX_VALUE);
                    newToken.setUser(user);
                    newToken.setTokenCreateDate();
                    newToken.setUserPlusPassHash(user.getEmail() + user.getPassword());
                    newToken.setToken();
                    tokenService.create(newToken);
                } else {
                    //if users token was in db ->delete and create new
                    tokenService.delete(thisToken.getToken());
                    newToken.setId(Integer.MAX_VALUE);
                    newToken.setUser(user);             //in future do refactor
                    newToken.setTokenCreateDate();
                    newToken.setUserPlusPassHash(user.getEmail() + user.getPassword());
                    newToken.setToken();
                    tokenService.create(newToken);
                }

            } catch (Exception ex) {
                //first login
                newToken.setId(Integer.MAX_VALUE);
                newToken.setUser(user);
                newToken.setTokenCreateDate();
                newToken.setUserPlusPassHash(usrPassHash);
                newToken.setToken();
                tokenService.create(newToken);

            }
            //add some logic
        result = builder.createJson();
        response.setStatus(200);
        response.setHeader("Headers", "{\"Content-Type\":\"application/json\"}");
        return result;
    } catch (Exception e) {
        response.setStatus(401);
        response.setHeader("Headers", "{\"Content-Type\":\"application/json\"}");
        return "{\"info\":\"Неверный пароль или логин\"}";
    }


}
}
