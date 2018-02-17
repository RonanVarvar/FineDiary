package com.FineDiary.controller.ResponseControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class StudentsList {


    @RequestMapping(value = "/studentsList", method = RequestMethod.GET)
    @ResponseBody
    public String  poster(HttpServletResponse response,
                          @RequestHeader(value = "Authorization") String token){




    }

}
