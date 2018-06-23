package com.discovery.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

    public static void main(final String[] args) {
        // By default Spring Boot applications look for an
        // application.properties or application.yml file for configuration. By
        // setting the spring.config.name property we can tell Spring Boot to
        // look for a different file - useful if you have multiple Spring Boot
        // applications in the same project

        // System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }

}
