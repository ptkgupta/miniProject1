package com.miniProject1.miniProject.service;

import com.miniProject1.miniProject.entities.Todo;
import com.miniProject1.miniProject.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class todoService {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Todo todo){
        entityManager.persist(todo);
        System.out.println("added");
    }
}
