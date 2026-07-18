package com.springboot.circular_dependency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CircularDependencyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order=context.getBean(OrderService.class);
        order.orderr();

    }

}
//The Best Practice is to refractor your code such that no circular dependency will arise

//singleton-stateless, eager initialization
//prototype-statefull,lazy initialization