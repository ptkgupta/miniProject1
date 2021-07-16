package com.miniProject1.miniProject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping("/login")
    public String loginMessage(){
        return "This is the login page where you can either register or you can login.";
    }
}
