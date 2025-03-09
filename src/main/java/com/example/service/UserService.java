package com.example.service;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional // Ensures all operations are treated as a single transaction
    public void registerUser(String name, String email){
        System.out.println("Registering user: " + name);

        // Insert user into database
        userDAO.save(new User(0,name,email));

        // Simulate an exception (to test rollback)
        if (email.contains("fail")){
            throw new RuntimeException("Simulated error: Rolling back transaction!");
        }

        System.out.println("User registered successfully.");
    }
}
