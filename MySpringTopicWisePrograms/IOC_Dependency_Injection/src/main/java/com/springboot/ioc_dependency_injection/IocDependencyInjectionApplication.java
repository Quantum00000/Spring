package com.springboot.ioc_dependency_injection;

import com.springboot.ioc_dependency_injection.Notification.EmailService;
import com.springboot.ioc_dependency_injection.Notification.NotificationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class IocDependencyInjectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocDependencyInjectionApplication.class, args);

        NotificationService notification = new EmailService();   //creating objects
        OrderService order = new OrderService(notification);    //passing object to the constructor, order is the object of EmailService
        order.sendNotification();    //calling method

        //Dependency injection via setter
        
        //NotificationService notification = new EmailService();
        //OrderService order = new OrderService();
        //order.setNotification(notification);


    }

}
