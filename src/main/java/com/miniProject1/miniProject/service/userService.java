package com.miniProject1.miniProject.service;


import com.miniProject1.miniProject.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class userService {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(User user){
        entityManager.persist(user);
        System.out.println("added");
    }

}
