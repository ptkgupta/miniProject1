package com.miniProject1.miniProject.service;

import com.miniProject1.miniProject.entities.Todo;
import com.miniProject1.miniProject.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public class todoService {

    @Autowired
    private TodoRepository repo;

    @PersistenceContext
    private EntityManager entityManager;


    public boolean insert(Todo todo){
        repo.saveAndFlush(todo);
        boolean added = repo.existsById(todo.getTodoId());
        return added;
    }

    public Todo retrieveTodo(UUID id){
        if(repo.existsById(id)) {
            return repo.getOne(id);
        }
        return new Todo("does not exist");
    }

    public List<Todo> retrieveSubTodo(UUID id){
        if(repo.existsById(id)) {
            List<Todo> subtasks =  repo.findByParentID(id);
            subtasks.sort(Comparator.comparing(Todo::getDueDate));
            return subtasks;
        }
        List<Todo> empty = Collections.<Todo>emptyList();

        return empty;
    }



    public void update(Todo todo){repo.saveAndFlush(todo);}

    public List<Todo> retieveAll(String name) {
        List<Todo> Tasks= repo.findByauthor(name);
        Tasks.sort(Comparator.comparing(Todo::getDueDate));
        return Tasks;
    }
}
