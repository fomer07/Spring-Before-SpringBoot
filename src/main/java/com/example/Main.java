package com.example;

import com.example.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load Spring Context from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        // Retrieve Bean
        HelloService helloService = context.getBean("helloService", HelloService.class);
        helloService.sayHello();

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}