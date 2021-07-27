package com.miniProject1.miniProject.service;

import com.miniProject1.miniProject.entities.Todo;
import com.miniProject1.miniProject.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public void update(Todo todo){repo.saveAndFlush(todo);}

    public List<Todo> retieveAll(String name) {
        return repo.findByauthor(name);
    }
}
