package com.example.config;

import com.example.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton") // Default scope (only one instance is created)
    public MessageService singletonMessageService() {
        return new MessageService();
    }

    @Bean
    @Scope("prototype") // New instance created on every request
    public MessageService prototypeMessageService() {
        return new MessageService();
    }
}
