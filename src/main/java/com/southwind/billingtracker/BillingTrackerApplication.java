package com.southwind.billingtracker;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillingTrackerApplication {

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://freetier-database.crefwdc52wtj.us-east-1.rds.amazonaws.com/postgres", "southwind0523", "password").load();
        flyway.migrate();
        SpringApplication.run(BillingTrackerApplication.class, args);
    }

}
