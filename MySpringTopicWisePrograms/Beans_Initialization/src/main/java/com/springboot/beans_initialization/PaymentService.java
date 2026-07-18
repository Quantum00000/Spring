package com.springboot.beans_initialization;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PaymentService {

    public void pay(){
        System.out.println("Paying......");
    }
}
