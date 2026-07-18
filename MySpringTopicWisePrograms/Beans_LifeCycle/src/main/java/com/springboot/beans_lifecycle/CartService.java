package com.springboot.beans_lifecycle;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Component
//1. Initialization Bean
public class CartService implements DisposableBean/*implements InitializingBean*/ {

    Map<Integer,String> mp;

    public CartService(){
        mp= new HashMap<>();
        System.out.println("Cart Service");
    }


   /*
   @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean Executed");
        mp.put(1,"Aman");
        mp.put(2,"balle balle");
    }
    */

    /*
    @PostConstruct
    public void starts(){
        System.out.println("Bean is ready");
        mp.put(1,"Aditya");
        mp.put(2,"Rohit");
    }
     */

    //Initialization callbacks--2. init method
    public void cartInfo(){
        System.out.println("Initializing Bean Executed");
        mp.put(1,"Aman");
        mp.put(2,"balle balle");
    }

    public String getvalue(Integer key){
        return mp.get(key);
    }

    //1.-Disposable Bean M1
    @Override
    public void destroy() throws Exception {
        System.out.println("Bean is getting destroyed..");
    }

    /*
    Destroy Bean M3
    @PreDestroy
    public void stop(){
        System.out.println("Bean is getting destroyed");
    }
     */
}
