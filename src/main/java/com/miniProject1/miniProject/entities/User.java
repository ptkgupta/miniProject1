package com.miniProject1.miniProject.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;


@Entity
public class User {
    public String name;
    private String password;
    @Id
    @GeneratedValue
    private UUID userId;

    protected  User(){}
    public User(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                '}';
    }
}