package com.example;


import com.example.config.AppConfig;
import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Load Spring Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get UserDAO Bean
        UserDAO userDAO = context.getBean(UserDAO.class);

        // Insert a new user
        User user = new User(0, "Jack Sparrow", "jack@sparrow.com");
        userDAO.save(user);

        // Retrieve user by ID
        User fetchedUser = userDAO.getById(1);
        System.out.println("Fetched User: " + fetchedUser);

        // Retrieve all users
        List<User> users = userDAO.getAll();
        System.out.println("All Users: " + users);

        // Update user
        fetchedUser.setName("Captain Jack Sparrow");
        userDAO.update(fetchedUser);

        // Delete user
        //userDAO.delete(1);

        // Close context
        ((AnnotationConfigApplicationContext) context).close();
    }
}