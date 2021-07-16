package com.miniProject1.miniProject.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.UUID;


public class User {
    public String name;
    private String password;
    private UUID userId;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.userId = UUID.randomUUID();
    }
}
