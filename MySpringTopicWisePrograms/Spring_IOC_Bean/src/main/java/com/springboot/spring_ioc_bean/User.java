package com.springboot.spring_ioc_bean;

import org.springframework.stereotype.Component;

//@Component
//In this situation our constructor and class implementation is bit hard, here @Component wont work as , ioc dont know the
//values of name and age
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


