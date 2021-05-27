package com.example.palmetto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PalmettoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PalmettoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Palmetto App");
    }
}