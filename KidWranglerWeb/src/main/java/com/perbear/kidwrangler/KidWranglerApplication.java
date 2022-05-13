package com.perbear.kidwrangler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class KidWranglerApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = (ApplicationContext) SpringApplication.run(KidWranglerApplication.class, args);


    }
}
