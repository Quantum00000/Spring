package com.springboot.beans_initialization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BeansInitializationApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order = context.getBean(OrderService.class);
        order.orderr();
    }

}

//NOTES

//Singleton-->Eager Initialization
//Prototype-->Lazy Initialization

//Singleton-->Eager-->Lazy(@Lazy)
//Prototype-->Lazy

//In OrderService-@Lazy is used to pass Proxy of paymentService to the orderService Object
//In PaymentService-@Lazy is used to make paymentService Lazy,so Object of paymentService is created only when needed

//IT CAN SOLVE CIRCULAR DEPENDENCY
//Placing @Lazy for paymentService like that ,pauses the auto creation of paymentService object and first OrderService
//object is created ,breaking circular dependency