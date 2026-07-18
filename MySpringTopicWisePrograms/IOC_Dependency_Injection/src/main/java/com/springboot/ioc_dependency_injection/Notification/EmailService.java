package com.springboot.ioc_dependency_injection.Notification;

public class EmailService implements NotificationService {

    @Override
    public void sendNotification(){
        System.out.println("Email notification sent");
    }
}
