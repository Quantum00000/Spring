package com.springboot.spring_ioc_bean.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

//When Orderservice ask for payment service bean it search for payment service bean where @Component annotation is there
//but when more than two classes implements interface have the annotation, then @Primary tells that required bean is this,
//else @Qualifier is used when we need to choose one of any of requirement.

//@Primary
@Qualifier("cd")
public class CardPayment implements PaymentService {

    @Override
    public void makePayment(){
        System.out.println("making card payment");
    }
}
