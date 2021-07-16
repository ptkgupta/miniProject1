package com.miniProject1.miniProject.objects;

import org.springframework.stereotype.Component;

import java.util.UUID;

public class userObj {
    public String name;
    public String Password;
    private UUID userId;

    public userObj(String name, String password) {
        this.name = name;
        Password = password;
        userId = UUID.randomUUID();
    }

    public UUID getUserId() {
        return userId;
    }
}