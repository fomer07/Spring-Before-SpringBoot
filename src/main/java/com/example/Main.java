package com.example;


import com.example.config.AppConfig;
import com.example.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
       // Load Spring Context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve Bean
        MessageService messageService = context.getBean(MessageService.class);
        System.out.println(messageService.getMessage());

        context.close();
    }
}