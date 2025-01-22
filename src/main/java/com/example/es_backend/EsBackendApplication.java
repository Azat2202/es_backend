package com.example.es_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsBackendApplication.class, args);
    }

}
