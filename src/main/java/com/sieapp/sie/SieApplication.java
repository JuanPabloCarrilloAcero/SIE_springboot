package com.sieapp.sie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
public class SieApplication {

    public static void main(String[] args) {
        SpringApplication.run(SieApplication.class, args);
    }

}
