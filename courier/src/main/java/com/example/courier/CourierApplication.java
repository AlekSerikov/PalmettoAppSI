package com.example.courier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourierApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CourierApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Courier App");
    }
}