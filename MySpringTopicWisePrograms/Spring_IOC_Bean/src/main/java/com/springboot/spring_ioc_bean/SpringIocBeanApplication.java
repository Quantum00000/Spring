package com.springboot.spring_ioc_bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class SpringIocBeanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

        // PaymentService payment =context.getBean(PaymentService.class);
        // payment.makePayment();

        User user = context.getBean(User.class);
        System.out.println(user.getName());



    }

}
