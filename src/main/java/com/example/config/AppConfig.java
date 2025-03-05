package com.example.config;

import com.example.service.MessageService;
import com.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks this clas as a Spring configuration class
@ComponentScan(basePackages = "com.example.service") // Enables component scanning
public class AppConfig {

    @Bean // Define a Spring bean
    public MessageService messageService() {
        return new MessageService();
    }

    @Bean
    public UserService userService(MessageService messageService) {
        return new UserService(messageService);
    }
}
