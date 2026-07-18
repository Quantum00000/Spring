package com.springboot.spring_ioc_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springboot.spring_ioc_bean")
public class AppConfig {

    @Bean
    public User makeUser(){
        return new User("Aman",21);
    }
}
