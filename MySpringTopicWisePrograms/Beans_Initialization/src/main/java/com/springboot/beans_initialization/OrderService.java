package com.springboot.beans_initialization;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    PaymentService paymentService;

    public OrderService(@Lazy PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public void orderr(){
        System.out.println("Placing order");
        paymentService.pay();
    }

}
