package com.miniProject1.miniProject.repositories;

import com.miniProject1.miniProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User,String> {
}
