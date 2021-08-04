package com.miniProject1.miniProject.repositories;

import com.miniProject1.miniProject.entities.Todo;
import com.miniProject1.miniProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public interface TodoRepository extends JpaRepository<Todo, UUID> {
//    List<Todo> findByParentID(UUID parentId);
    List<Todo> findByauthor(String author);
//    List<Todo> findByarchived(boolean bool);

//    void deleteByArchivedIsTrueAndDueDateIsBefore(LocalDate date);




}
