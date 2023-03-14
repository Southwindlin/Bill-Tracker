package com.southwind.billingtracker;

import com.southwind.billingtracker.service.FlywayMigrationService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillingTrackerApplication {

    @Autowired
    private FlywayMigrationService flywayMigrationService;

    public static void main(String[] args) {
        SpringApplication.run(BillingTrackerApplication.class, args);
    }

    @PostConstruct
    public void migrateDatabase() {
        flywayMigrationService.migrate();
    }
}
