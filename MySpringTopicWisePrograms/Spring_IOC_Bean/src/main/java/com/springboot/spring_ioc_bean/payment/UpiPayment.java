package com.springboot.spring_ioc_bean.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("upi")
public class UpiPayment implements PaymentService{

    @Override
    public void makePayment(){
        System.out.println("making upi payment");
    }
}
