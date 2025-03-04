package com.example.config;

import com.example.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks this clas as a Spring configuration class
public class AppConfig {

    @Bean // Define a Spring bean
    public HelloService helloService() {
        return new HelloService();
    }

}
