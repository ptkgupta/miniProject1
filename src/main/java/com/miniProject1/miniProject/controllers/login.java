package com.miniProject1.miniProject.controllers;

import org.springframework.stereotype.Component;

@Component
public class login {
    public String email;
    public String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
