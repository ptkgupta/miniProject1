package com.miniProject1.miniProject.controllers;


//import com.miniProject1.miniProject.objects.userObject;
import com.miniProject1.miniProject.entities.User;
import com.miniProject1.miniProject.repositories.UserRepository;
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
    private userService service;

    @ResponseBody
    @RequestMapping("/login")
    public String loginMessage(){
        return "This is the login page where you can either register or you can login.";
    }

    @RequestMapping("/userlogin")
    @ResponseBody
    public String userLogin(@RequestParam(required=true) String name, @RequestParam(required = true) String password){
        User loginUser = new User(name,password);
        boolean clear = service.validate(loginUser);
        if(clear)
            return("valid user");
        else
            return("invalid user");
    }

    @ResponseBody
    @RequestMapping("/newUser")
    public String newUSer(@RequestParam(required = true) String name, @RequestParam(required = true) String password)
    {
        User newUser = new User(name,password);
        boolean inserted = service.insert(newUser);
        if (inserted) return ("New user has been created as follows \n"+newUser.toString());
        else return("User already exists");
    }

    @ResponseBody
    @RequestMapping("/deleteUser")
    public String deleteUSer(@RequestParam(required = true) String name, @RequestParam(required = true) String password)
    {
        User newUser = new User(name,password);
        boolean deleted = service.delete(newUser);
        if (deleted) return ("user has been deleted");
        else return("User does not exist");
    }

    @ResponseBody
    @RequestMapping("/changePassword")
    public String changePassword(@RequestParam(required = true) String name, @RequestParam(required = true) String oldPassword,@RequestParam(required = true) String newPassword1, @RequestParam(required = true) String newPassword2)
    {
        User user = new User(name,oldPassword);
        if(!service.validate(user)) return("Invalid password");
        if(!newPassword1.equals(newPassword2)) return("The passwords don't match.");

        User user_old = service.retrieveUser(name);
        user_old.setPassword(newPassword1);
        service.update(user_old);
        return("User updated");
    }
}