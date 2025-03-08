package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example")  // Scans for @Component, @Service, @Aspect
@EnableAspectJAutoProxy // Enables Spring AOP
public class AppConfig {
}
