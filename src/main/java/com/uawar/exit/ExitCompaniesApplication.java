package com.uawar.exit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories({"com.uawar.exit"})
public class ExitCompaniesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExitCompaniesApplication.class, args);
    }

}
