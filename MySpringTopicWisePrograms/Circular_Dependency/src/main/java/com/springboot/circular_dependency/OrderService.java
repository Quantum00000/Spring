package com.springboot.circular_dependency;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public void orderr(){
        System.out.println("Making payment");

        paymentService.makePayment();
    }
}
