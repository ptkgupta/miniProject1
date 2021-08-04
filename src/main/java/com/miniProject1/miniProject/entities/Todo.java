package com.miniProject1.miniProject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

@Entity
public class Todo {

    @Id
    public UUID todoId;
//    public String title;
    public String desc;
    public String author;
    public LocalDate dueDate;
//    public UUID parentID;
    public boolean completed;
//    public boolean archived;

    public Todo(){}

    public Todo(String title, String desc, String author, LocalDate dueDate, boolean completed, boolean archived) {
  //      this.title = title;
        this.desc = desc;
        this.todoId = UUID.randomUUID();
        this.author = author;
        this.dueDate = dueDate;
//        this.parentID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        this.completed = completed;
//        this.archived = archived;

    }



    public Todo(String Name, String desc, LocalDate date) {
//        this.title = "Title";
        this.desc = desc;
        this.todoId = UUID.randomUUID();
        this.author = Name;
        this.dueDate = date;
        this.completed = false;
//        this.archived = false;
//        this.parentID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    }

    public Todo(String Name, UUID id) {
//        this.title = "Title";
        this.desc = "Description";
        this.todoId = UUID.randomUUID();
        this.author = Name;
        this.dueDate = LocalDate.now();
        this.completed = false;
//        this.archived = false;
//        this.parentID = id;

    }

    public UUID getTodoId() {
        return todoId;
    }

    public void changeStatus(){
        this.completed = !this.completed;
    }

//    public void changeArchive(){
//        this.archived = !this.archived;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

}