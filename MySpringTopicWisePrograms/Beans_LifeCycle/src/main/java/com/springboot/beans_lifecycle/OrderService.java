package com.springboot.beans_lifecycle;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public void Orderr(){
        System.out.println("Order PLaced");
        paymentService.pay();
    }
}
