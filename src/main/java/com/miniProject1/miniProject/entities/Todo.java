package com.miniProject1.miniProject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Todo {
    @Id
    private UUID todo_ID;
    public String text;
    public Date deadline;
    public String title;
    public String userName;

    protected Todo(){}
    public Todo(String text, Date deadline, String title, String userName) {
        super();
        this.text = text;
        this.deadline = deadline;
        this.title = title;
        this.userName = userName;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getTodo_ID() {
        return todo_ID;
    }

    public String getText() {
        return text;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todo_ID=" + todo_ID +
                ", text='" + text + '\'' +
                ", deadline=" + deadline +
                ", title='" + title + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
