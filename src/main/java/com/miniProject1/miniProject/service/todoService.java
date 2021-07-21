package com.miniProject1.miniProject.service;

import com.miniProject1.miniProject.entities.Todo;
import com.miniProject1.miniProject.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class todoService {

    @Autowired
    private TodoRepository repo;

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Todo todo){
        entityManager.persist(todo);
        System.out.println("added");
    }
}
