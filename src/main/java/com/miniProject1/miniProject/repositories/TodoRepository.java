package com.miniProject1.miniProject.repositories;

import com.miniProject1.miniProject.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface TodoRepository extends JpaRepository<Todo, UUID> {}