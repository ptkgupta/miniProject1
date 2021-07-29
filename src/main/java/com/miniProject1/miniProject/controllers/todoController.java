package com.miniProject1.miniProject.controllers;

import com.miniProject1.miniProject.entities.Todo;
import com.miniProject1.miniProject.service.todoService;
import com.miniProject1.miniProject.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
// by status I mean completion
    @GetMapping("/login/tasks/changeStatus")
    @ResponseBody
    public void changeStatus(@RequestParam(required = true) UUID todoid ){
        Todo todo = service.retrieveTodo(todoid);
        todo.changeStatus();
        service.update(todo);
    }
// change archive status
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
    public void changeDueDate(@RequestParam(required = true) UUID todoid, @RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate date){
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
// retrieve all only gets the parent Todoss including the archived ones
    @GetMapping("/login/tasks/retrieveAll")
    @ResponseBody
    public List<Todo> retrieveAll(@RequestParam(required = true) String name){
        return service.retieveAll(name);
    }

    // no archived tasks listed
    @GetMapping("/login/tasks/retrieveTasks")
    @ResponseBody
    public List<Todo> retrieveTasks(@RequestParam(required = true) String name){
        List<Todo> allTodos = service.retieveAll(name);
        List<Todo> currentTodos = new ArrayList<Todo>();
        Iterator<Todo> itr = allTodos.iterator();
        while(itr.hasNext()){
            if(((Todo) itr.next()).archived){
                currentTodos.add(((Todo)itr.next()));
            }
        }
        return currentTodos;
    }



    @GetMapping("/login/tasks/retrieveArchive")
    @ResponseBody
    public List<Todo> retrieveArchive(@RequestParam(required = true) String name){
        List<Todo> allTodos = service.retieveAll(name);
        List<Todo> currentTodos = new ArrayList<Todo>();
        Iterator<Todo> itr = allTodos.iterator();
        while(itr.hasNext()){
            if(!((Todo) itr.next()).archived){
                currentTodos.add(((Todo)itr.next()));
            }
        }
        return currentTodos;
    }

    @GetMapping("/login/tasks/retrievecompleted")
    @ResponseBody
    public List<Todo> retrievecompleted(@RequestParam(required = true) String name){
        List<Todo> allTodos = service.retieveAll(name);
        List<Todo> currentTodos = new ArrayList<Todo>();
        Iterator<Todo> itr = allTodos.iterator();
        while(itr.hasNext()){
            if(((Todo) itr.next()).completed){
                currentTodos.add(((Todo)itr.next()));
            }
        }
        return currentTodos;
    }

    @GetMapping("/login/tasks/retrieveByDate")
    @ResponseBody
    public List<Todo> retrieveByDate(@RequestParam(required = true) String name,@RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
        List<Todo> allTodos = service.retieveAll(name);
        List<Todo> currentTodos = new ArrayList<Todo>();
        Iterator<Todo> itr = allTodos.iterator();
        while (itr.hasNext()) {
            if (((Todo) itr.next()).dueDate == date) {
                currentTodos.add(((Todo) itr.next()));
            }
        }
        return currentTodos;
    }

}
