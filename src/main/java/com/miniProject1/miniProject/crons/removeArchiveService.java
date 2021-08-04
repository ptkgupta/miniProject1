package com.miniProject1.miniProject.crons;

import com.miniProject1.miniProject.entities.Todo;
import com.miniProject1.miniProject.repositories.TodoRepository;
import com.miniProject1.miniProject.service.todoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Component
@EnableScheduling
public class removeArchiveService {
//
//    @Autowired
//    private todoService service;
//    @Autowired
//    private TodoRepository repo;
//
//    @Transactional
//    @Scheduled(cron = "* * * ? * *")
//    public void remove_archived(){
//        List<Todo> archived = repo.findByarchived(true);
//        LocalDate rightNow= LocalDate.now();
//        repo.deleteByArchivedIsTrueAndDueDateIsBefore(rightNow.minusDays(15));
//        System.out.println(rightNow.minusDays(15).toString());
//    }
}
