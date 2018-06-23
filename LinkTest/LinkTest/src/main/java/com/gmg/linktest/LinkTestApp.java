package com.gmg.linktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gmg.linktest")
public class LinkTestApp {

    public static void main(final String[] args) {
        SpringApplication.run(LinkTestApp.class, args);
    }

}
