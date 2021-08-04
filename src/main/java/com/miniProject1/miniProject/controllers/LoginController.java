package com.miniProject1.miniProject.controllers;


//import com.miniProject1.miniProject.objects.userObject;
import com.miniProject1.miniProject.entities.User;
import com.miniProject1.miniProject.repositories.UserRepository;
import com.miniProject1.miniProject.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.lang.String;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {

    @Autowired
    private userService service;

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ResponseBody
    @RequestMapping("/")
    public String loginMessage(){
        return "This is the login page where you can either register or you can login.";
    }

    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/userlogin")
    public Boolean userLogin(@RequestParam(required=true) String name, @RequestParam(required = true) String password){
        User loginUser = new User(name,password);
        return service.validate(loginUser);
    }

    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/newUser")
    public Boolean newUSer(@RequestParam(required = true) String name, @RequestParam(required = true) String password)
    {
        User newUser = new User(name,password);
        boolean inserted = service.insert(newUser);
        System.out.println(inserted);
        return (inserted);
    }

//
//    @RequestMapping(value =  "/newUser")
//    @ResponseBody
//    public String addProduct(@RequestParam login Login)
//    {
//        User newUser = new User(Login.email,Login.password);
//        boolean inserted = service.insert(newUser);
//        System.out.println("user registered");
//        if (inserted) return ("New user has been created as follows \n"+newUser.toString());
//        else return("User already exists");
//    }


    @RequestMapping("/welcome")
    @ResponseBody
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String welcome()
    {
        return("Thank you for choosing us");
    }

    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/login/deleteUser")
    public String deleteUSer(@RequestParam(required = true) String name, @RequestParam(required = true) String password)
    {
        User newUser = new User(name,password);
        boolean deleted = service.delete(newUser);
        if (deleted) return ("user has been deleted");
        else return("User does not exist");
    }
}