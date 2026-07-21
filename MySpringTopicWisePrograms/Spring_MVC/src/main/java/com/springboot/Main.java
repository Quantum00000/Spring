package com.springboot;

import com.springboot.Config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  throws LifecycleException {

        //Tomcat Boiler plate
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.getConnector();

        String contextPath="";
        String baseDoc=new File("src/main/webapp").getAbsolutePath();

        Context context = tomcat.addContext(contextPath,baseDoc);

        //IOC Container

        AnnotationConfigWebApplicationContext springContext = new
                AnnotationConfigWebApplicationContext();

        springContext.register(WebConfig.class);

        //Dispatcher Servlet

        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

        tomcat.addServlet(
                context,"dispatcherServlet",dispatcherServlet
        );

        context.addServletMappingDecoded(
                "/","dispatcherServlet"
        );

        tomcat.start();

        System.out.println("tomcat Server has been started at port 8080");

        tomcat.getServer().await();





        /*
        Notes-----------

        1> Add maven dependencies tomcat,jackson,MVC
        2> MVC- Model View Controller
        3> ADD tomcat boiler plate ,IOC Container ,Dispatcher Servlet in main.java
        4> In entities add no args constructor cause jackson cant make student object directly
        5> In controller , return Response Entity
        6> In Repository, Creat hash map as Database
        
         */



    }
}
