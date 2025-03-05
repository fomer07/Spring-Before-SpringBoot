package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Marks this class a Spring-managed component
public class UserService {

    private final MessageService messageService;

    // Constructor based dependency injection
    @Autowired
    public UserService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void printMessage() {
        System.out.println(messageService.getMessage());
    }
}
