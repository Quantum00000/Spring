package com.springboot.servlet.Model;

public class User {

    private Integer id;
    private String name;
    private String email;
    private Integer number;


    public User(Integer id, String name, String email,Integer number ){
        this.id=id;
        this.name=name;
        this.email=email;
        this.number=number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
