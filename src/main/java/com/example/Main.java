package com.example;


import com.example.config.AppConfig;
import com.example.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
       // Load Spring Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Requesting singletonMessageService...");
        MessageService s1 = context.getBean("singletonMessageService", MessageService.class);
        MessageService s2 = context.getBean("singletonMessageService", MessageService.class);

        System.out.println("Are singleton beans are the same? " + (s1 == s2)); // Should print true

        System.out.println("Requesting prototypeMessageService...");
        MessageService p1 = context.getBean("prototypeMessageService", MessageService.class);
        MessageService p2 = context.getBean("prototypeMessageService", MessageService.class);

        System.out.println("Are prototypes beans are the same? " + (p1 == p2)); // Should print false

        ((AnnotationConfigApplicationContext) context).close();
    }
}