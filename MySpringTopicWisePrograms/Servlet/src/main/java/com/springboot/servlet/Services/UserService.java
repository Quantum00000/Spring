package com.springboot.servlet.Services;

import com.springboot.servlet.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private final Map<Integer, User> userDb;
//Constructor
    public UserService(){
        userDb = new HashMap<>();
    }
//Create user
    public User createUser(User userReq){
        userDb.put(userReq.getId(),userReq);
        return userReq;
    }
//Get users by id
    public User getUserById(Integer id){

        User user = userDb.get(id);

        return user;
    }
//Get all users
    public List<User> getAllUsers(){
        List<User> userResp = new ArrayList<>();

        userResp.addAll(userDb.values());
        return userResp;
    }

//Delete by id
    public  void deleteById(Integer id){
        userDb.remove(id);
    }

}
