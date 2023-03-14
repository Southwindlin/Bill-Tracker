package com.southwind.billingtracker;

import com.southwind.billingtracker.config.flyway.FlywayConfiguration;
import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BillingTrackerApplication {

    @Autowired
    private FlywayMigration flywayMigration;

    public static void main(String[] args) {
        SpringApplication.run(BillingTrackerApplication.class, args);
    }

    @PostConstruct
    public void migrateDatabase() {
        flywayMigration.migrate();
    }
}
