package com.example;

import com.example.config.AppConfig;
import com.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load Spring Context using Java Config
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve UserService Bean
        UserService userService = context.getBean(UserService.class);
        userService.printMessage(); // Calls MessageService internally

        // Close context
        ((AnnotationConfigApplicationContext) context).close();
    }
}