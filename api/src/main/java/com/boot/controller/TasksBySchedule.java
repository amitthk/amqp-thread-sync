package com.boot.controller;


import com.boot.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TasksBySchedule {

    @Autowired
    RabbitMQService rabbitMQService;

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {

        long now = System.currentTimeMillis() / 1000;
        String message =   "Fixed rate task with one second initial delay - " + now;
        rabbitMQService.send(message);
    }

}
