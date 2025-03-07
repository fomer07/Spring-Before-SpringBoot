package com.example.aspect;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // Marks this is an Aspect class
@Component // Registers it as a Spring Bean
public class LoggingAspect {

    // Define a common pointcut for all methods in UserService
    @Pointcut("execution(* com.example.service.UserService.*(..))")
    public void userServiceMethods() {}

    @Before("userServiceMethods()")
    public void beforeMethod() {
        System.out.println("[AOP] Before method execution...");
    }

    @After("userServiceMethods()")
    public void afterMethod() {
        System.out.println("[AOP] After method execution...");
    }

    @AfterReturning("userServiceMethods()")
    public void afterReturningMethod() {
        System.out.println("[AOP] After method successfully returns...");
    }

    @AfterThrowing("userServiceMethods()")
    public void afterThrowingMethod() {
        System.out.println("[AOP] Exception thrown in method...");
    }
}
