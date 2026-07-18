package com.example.learning_01.controllers;


import com.example.learning_01.dto.OrderRequest;
import com.example.learning_01.entites.Order;
import com.example.learning_01.services.OrderServices;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServices orderServices;

    @PostMapping
    public Order createOrder(@Valid @RequestBody OrderRequest orderRequest){
        return orderServices.createOrder(orderRequest);
    }

    //TO DO

    //get all orders
    public List<Order> getAllOrders(){
        return null;
    }

    //get order by id
    public Order orderById(Id id){
        return null;
    }


}
