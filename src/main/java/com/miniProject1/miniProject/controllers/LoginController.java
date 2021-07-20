package com.miniProject1.miniProject.controllers;


//import com.miniProject1.miniProject.objects.userObject;
import com.miniProject1.miniProject.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.String;

@Controller
public class LoginController {


    @ResponseBody
    @RequestMapping("/login")
    public String loginMessage(){
        return "This is the login page where you can either register or you can login.";
    }

    @ResponseBody
    @RequestMapping("/newUser")
    public User loginMessage(@RequestParam(required = true) String name, @RequestParam(required = true) String password)
    {
        User newUser = new User(name,password);
        return newUser;
    }
}