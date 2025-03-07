package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void createUser(String username) {
        System.out.println("UserService: Creating user - " + username);
    }
}
