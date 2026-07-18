package com.springboot.spring_ioc_bean;
import com.springboot.spring_ioc_bean.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    //Field Injection
    //@Autowired
    private final PaymentService paymentService;

    //Constructor Injection
    @Autowired
    public OrderService(@Qualifier("upi") PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public void placeOrder(){
        System.out.println("order is placed");
        paymentService.makePayment();

    }

}
