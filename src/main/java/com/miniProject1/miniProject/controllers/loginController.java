package com.miniProject1.miniProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {

    @ResponseBody
    @RequestMapping("/login")
    public String loginMessage() {
        return "Hello this is the login page";
    }
}
