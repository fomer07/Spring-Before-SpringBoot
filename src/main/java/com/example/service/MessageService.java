package com.example.service;

public class MessageService {

    public MessageService(){
        System.out.println("MessageService instance created!");
    }
    public String getMessage() {
        return "Hello from MessageService!";
    }
}
