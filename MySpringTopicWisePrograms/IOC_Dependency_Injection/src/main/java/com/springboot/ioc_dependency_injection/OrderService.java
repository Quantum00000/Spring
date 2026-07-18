package com.springboot.ioc_dependency_injection;
import com.springboot.ioc_dependency_injection.Notification.NotificationService;


public class OrderService {

    //[1]-NotificationService notification = new SmsService(); //OrderService should only have business logic, it wont be creating objects
    NotificationService notification;  //So we created notification instance and now we will create a constructor

    public OrderService(NotificationService notification){
        this.notification=notification;  // first notification is instance and second one is argument
    }

    //Dependency injection via setter

    //public void setNotification(NotificationService notification) {
    //    this.notification = notification;
    //}

    public void sendNotification(){
        notification.sendNotification();
    }
}
