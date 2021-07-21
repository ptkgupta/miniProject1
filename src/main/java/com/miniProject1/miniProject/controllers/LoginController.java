package com.miniProject1.miniProject.controllers;


//import com.miniProject1.miniProject.objects.userObject;
import com.miniProject1.miniProject.entities.User;
import com.miniProject1.miniProject.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.String;

@Controller
public class LoginController {

    @Autowired
    private userService userservice;

    @ResponseBody
    @RequestMapping("/login")
    public String loginMessage(){
        return "This is the login page where you can either register or you can login.";
    }

    @RequestMapping("/userlogin")
    public String userLogin(){
        return "This is the login page where you can either register or you can login.";
    }

    @ResponseBody
    @RequestMapping("/newUser")
    public String loginMessage(@RequestParam(required = true) String name, @RequestParam(required = true) String password)
    {
        User newUser = new User(name,password);
        userservice.insert(newUser);
        return ("New user has been created as follows \n"+newUser.toString());
    }
}