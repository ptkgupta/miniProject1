package com.miniProject1.miniProject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Entity

public class Todo {

    @Id
    @GeneratedValue
    public UUID todoId;
    public String title;
    public String desc;
    public String author;
    public LocalDate dueDate;
    public UUID parentID;
    public boolean completed;
    public boolean archived;

    public Todo(String title, String desc, String author, LocalDate dueDate, boolean completed, boolean archived) {
        this.title = title;
        this.desc = desc;
        this.author = author;
        this.dueDate = dueDate;
        this.parentID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        this.completed = completed;
        this.archived = archived;

    }

    public Todo() {
        this.title = "Title";
        this.desc = "Description";
        this.author = "User";
        this.dueDate = LocalDate.of(2018, Month.OCTOBER, 12);
        this.completed = false;
        this.archived = false;
        this.parentID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    }


}
