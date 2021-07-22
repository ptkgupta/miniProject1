package com.miniProject1.miniProject.controllers;

import com.miniProject1.miniProject.entities.Todo;
import com.miniProject1.miniProject.service.todoService;
import com.miniProject1.miniProject.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class todoController {

    @Autowired
    private todoService service;
    @Autowired
    private userService userService;

    @GetMapping("/login/tasks/newTask")
    @ResponseBody
    public boolean newTask(@RequestParam(required = true) String Name){
        Todo newtodo = new Todo(Name);
        return service.insert(newtodo);
    }

    @GetMapping("/login/tasks/changeStatus")
    @ResponseBody
    public void changeStatus(@RequestParam(required = true) UUID todoid ){
        Todo todo = service.retrieveTodo(todoid);
        todo.changeStatus();
        service.update(todo);
    }

    @GetMapping("/login/tasks/changeArchive")
    @ResponseBody
    public void changeArchive(@RequestParam(required = true) UUID todoid ){
        Todo todo = service.retrieveTodo(todoid);
        todo.changeArchive();
        service.update(todo);
    }

    @GetMapping("/login/tasks/changeTitle")
    @ResponseBody
    public void changetitle(@RequestParam(required = true) UUID todoid, @RequestParam(required = true) String title ){
        Todo todo = service.retrieveTodo(todoid);
        todo.setTitle(title);
        service.update(todo);
    }

    @GetMapping("/login/tasks/changeDesc")
    @ResponseBody
    public void changedesc(@RequestParam(required = true) UUID todoid, @RequestParam(required = true) String desc ){
        Todo todo = service.retrieveTodo(todoid);
        todo.setDesc(desc);
        service.update(todo);
    }

    @GetMapping("/login/tasks/changeDueDate")
    @ResponseBody
    public void changeDueDate(@RequestParam(required = true) UUID todoid, @RequestParam(required = true) LocalDate date){
        Todo todo = service.retrieveTodo(todoid);
        todo.setDueDate(date);
        service.update(todo);
    }

    @GetMapping("/login/tasks/newSubTask")
    @ResponseBody
    public boolean newSubTask(@RequestParam(required = true) Todo todo){
        Todo newTodo = new Todo(todo.author, todo.getTodoId());
        return service.insert(newTodo);
    }

    @GetMapping("/login/tasks/retrieveAll")
    @ResponseBody
    public List<Todo> retrieveAll(@RequestParam(required = true) String name){
        List<Todo> allTodos = service.retieveAll(name);
        return allTodos;
    }
}
