package com.springboot.circular_dependency;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    OrderService orderService;

    public PaymentService(OrderService orderService){
        this.orderService=orderService;
    }

    public void makePayment(){
        System.out.println("Making payment");

        orderService.orderr();
    }

}
