package com.springboot.ioc_dependency_injection.Notification;

public class SmsService implements NotificationService{

    @Override
    public void sendNotification(){
        System.out.println("Sending sms");
    }
}
