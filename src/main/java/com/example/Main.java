package com.example;


import com.example.config.AppConfig;
import com.example.dao.UserDAO;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Load Spring Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get UserService Bean
        UserService userService = context.getBean(UserService.class);

        // Successful transaction
        try {
            userService.registerUser("Jack Sparrow", "jack@sparrow.com");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Failing transaction (should rollback)
        try {
            userService.registerUser("Hector Barbossa", "fail@pirate.com");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Close context
        ((AnnotationConfigApplicationContext) context).close();
    }
}