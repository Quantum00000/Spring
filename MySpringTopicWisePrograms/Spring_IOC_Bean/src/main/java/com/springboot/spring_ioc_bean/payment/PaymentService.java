//PART_1

//package com.springboot.spring_ioc_bean;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class PaymentService {
//
//    public void makePayment(){
//        System.out.println("Payment made");
//    }
//}


//PART_2

package com.springboot.spring_ioc_bean.payment;

import org.springframework.stereotype.Component;


public interface PaymentService {

    public void makePayment();
}
