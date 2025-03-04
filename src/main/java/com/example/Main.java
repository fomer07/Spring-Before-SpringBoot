package com.example;

import com.example.config.AppConfig;
import com.example.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load Spring Context using Java Config
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve Bean
        HelloService helloService = context.getBean(HelloService.class);
        helloService.sayHello();

        // Close context
        ((AnnotationConfigApplicationContext) context).close();
    }
}