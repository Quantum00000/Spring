package com.springboot.beans_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    //Initialization callbacks--2. init method  + DestroyBean M2( Destroy Method )
    @Bean(initMethod = "cartInfo"/*,destroyMethod = "destroy"*/)
    public CartService getNewBean(){
        return new CartService();
    }
}
