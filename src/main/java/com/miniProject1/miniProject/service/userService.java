package com.miniProject1.miniProject.service;


import com.miniProject1.miniProject.entities.User;
import com.miniProject1.miniProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class userService {

    @Autowired
    private UserRepository repo;

    @PersistenceContext
    private EntityManager entityManager;

    public boolean insert(User user){
        boolean present = repo.existsById(user.name);
        if (!present) {
            repo.saveAndFlush(user);
            return true;
        }
        else return false;
    }

    public boolean validate(User user){
        boolean present = repo.existsById(user.name);
        if (present) {
            User old = new User();
            old = repo.getOne(user.name);
            System.out.println(user.getPassword());
            System.out.println(old.getPassword());
            System.out.println((user.getPassword().equals(old.getPassword())));
            return (user.getPassword().equals(old.getPassword()));
        }
        return false;
    }


    public boolean delete(User user) {
        if(validate(user)){
            repo.delete(user);
            return true;
        }else return false;
    }
}
