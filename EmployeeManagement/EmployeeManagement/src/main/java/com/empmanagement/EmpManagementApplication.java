package com.empmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.empmanagement")
@EnableDiscoveryClient
public class EmpManagementApplication {

    public static void main(final String[] args) {
        SpringApplication.run(EmpManagementApplication.class, args);
    }

}
