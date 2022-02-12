package com.bilgeadam.bolumapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BolumAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BolumAppApplication.class, args);
    }

}
