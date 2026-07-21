package com.springboot.Entities;
public class Student {

    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Integer phonenumber;

    public Student(){

    }

    public Student(Integer id,String name, Integer age, String email, Integer phonenumber) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phonenumber = phonenumber;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }
}
