package com.springboot.beans_lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BeansLifeCycleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order =context.getBean(OrderService.class);
        order.Orderr();

        CartService cart =context.getBean(CartService.class);
        System.out.println(cart.getvalue(2));

        //1.-Disposable Bean M1
        context.close();
    }

}

//BEAN LIFECYCLE

/*IOC Container start --> Read Configuration --> Read Bean Definition
                             |
                            \|/
                             '
Bean Definition = bean name:Order service
                  bean Class:order Service
                  scope: Singleton
                  lazy:false

--> Instantiate Objects --> Dependencies are injected --> Aware Interfaces are called(Ex-BeanAwareName)"They are called by spring"
--> Initialization callbacks [ 1. InitializationBean - Implementing InitializingBean interface, overriding method
                               2. init Method - init method is defined in the class and called from the AppConfig
                               3. Post Construct -@Postconstruct annotation is used]
--> Bean is ready to use -->Destruction callbacks
                               [ 1.DisposableBean - implement Desposable Bean interface
                                 2.destroyMethod - destroy method is called from the AppConfig
                                 3.Pre Destroy   ]




Note :- Circular Dependency can be solved by PostConstruct annotation
*/


