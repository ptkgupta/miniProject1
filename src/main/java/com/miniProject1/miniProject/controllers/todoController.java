package com.miniProject1.miniProject.controllers;

import com.miniProject1.miniProject.entities.Todo;
import com.miniProject1.miniProject.service.todoService;
import com.miniProject1.miniProject.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class todoController {

    @Autowired
    private todoService service;
    @Autowired
    private userService userService;

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/login/tasks/newTask")
    @ResponseBody
    public UUID newTask(@RequestParam(required = true) String Name, @RequestParam(required = true) String desc, @RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate date){
        Todo newtodo = new Todo(Name,desc, date);
        service.insert(newtodo);
        return newtodo.todoId;
    }
// by status I mean completion
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/login/tasks/changeStatus")
    @ResponseBody
    public void changeStatus(@RequestParam(required = true) UUID todoid ){
        Todo todo = service.retrieveTodo(todoid);
        todo.changeStatus();
        service.update(todo);
    }
//// change archive status
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @GetMapping("/login/tasks/changeArchive")
//    @ResponseBody
//    public void changeArchive(@RequestParam(required = true) UUID todoid ){
//        Todo todo = service.retrieveTodo(todoid);
//        todo.changeArchive();
//        service.update(todo);
//    }

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @GetMapping("/login/tasks/changeTitle")
//    @ResponseBody
//    public void changetitle(@RequestParam(required = true) UUID todoid, @RequestParam(required = true) String title ){
//        Todo todo = service.retrieveTodo(todoid);
//        todo.setTitle(title);
//        service.update(todo);
//    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/login/tasks/changeDesc")
    @ResponseBody
    public void changedesc(@RequestParam(required = true) String todoid, @RequestParam(required = true) String desc ){
        Todo todo = service.retrieveTodo(UUID.fromString(todoid));
        todo.setDesc(desc);
        service.update(todo);
    }

    @GetMapping("/login/tasks/changeDueDate")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void changeDueDate(@RequestParam(required = true) UUID todoid, @RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate date){
        Todo todo = service.retrieveTodo(todoid);
        todo.setDueDate(date);
        service.update(todo);
    }

    @GetMapping("/login/tasks/newSubTask")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public boolean newSubTask(@RequestParam(required = true) Todo todo){
        Todo newTodo = new Todo(todo.author, todo.getTodoId());
        return service.insert(newTodo);
    }
// retrieve all only gets the parent Todoss including the archived ones
    @GetMapping("/login/tasks/retrieveAll")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Todo> retrieveAll(@RequestParam(required = true) String name){
        return service.retieveAll(name);
    }

//    // no archived tasks listed
//    @GetMapping("/login/tasks/retrieveTasks")
//    @ResponseBody
////    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    public List<Todo> retrieveTasks(@RequestParam(required = true) String name){
//        List<Todo> allTodos = service.retieveAll(name);
//        List<Todo> currentTodos = new ArrayList<Todo>();
//        Iterator<Todo> itr = allTodos.iterator();
//        while(itr.hasNext()){
//            if(((Todo) itr.next()).archived){
//                currentTodos.add(((Todo)itr.next()));
//            }
//        }
//        return currentTodos;
//    }



//    @GetMapping("/login/tasks/retrieveArchive")
//    @ResponseBody
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    public List<Todo> retrieveArchive(@RequestParam(required = true) String name){
//        List<Todo> allTodos = service.retieveAll(name);
//        List<Todo> currentTodos = new ArrayList<Todo>();
//        Iterator<Todo> itr = allTodos.iterator();
//        while(itr.hasNext()){
//            if(!((Todo) itr.next()).archived){
//                currentTodos.add(((Todo)itr.next()));
//            }
//        }
//        return currentTodos;
//    }

    @GetMapping("/login/tasks/retrievecompleted")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
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