package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron="0 0 10 * * *")
    //@Scheduled(fixedDelay = 10000)
    private void sendInformationEmail(){
        simpleEmailService.sendDailyMail(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Your daily update email."));

        /*long size = taskRepository.count();
        String taskOrTasks = size >=0 ? " tasks" : " task";
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you got: " + size + taskOrTasks*//*taskOrTasks()*//*
        ));*/
    }

   /* private String taskOrTasks(){
        long size = taskRepository.count();
        if(size > 1){
            return size + " tasks";
        } else if(size == 1){
            return size + " task";
        } else {
            return "no tasks";
        }
    }*/
}
