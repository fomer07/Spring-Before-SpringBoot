package com.example.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MessageService {

    public MessageService(){
        System.out.println("MessageService instance created!");
    }

    @PostConstruct
    public void init(){
        System.out.println("MessageService: Initialization logic (PostConstruct)");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("MessageService: Cleanup logic (PreDestroy)");
    }

    public String getMessage(){
        return "Hello from MessageService!";
    }
}
