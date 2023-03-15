package com.southwind.billingtracker.service;

import com.southwind.billingtracker.config.flyway.FlywayConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.MigrationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FlywayMigrationService {

    private Flyway flyway;

    @Autowired
    public FlywayMigrationService(FlywayConfiguration flywayConfiguration) {
        try {
            this.flyway = Flyway.configure()
                    .dataSource(flywayConfiguration.getUrl(), flywayConfiguration.getUsername(), flywayConfiguration.getPassword())
                    .load();
        } catch (Exception e) {
            log.error("Failed to initialize Flyway: {}", e.getMessage());
            throw new RuntimeException("Failed to initialize Flyway", e);
        }
    }
    private void setBaseline() {
        flyway.baseline();
    }

    private MigrationInfo[] getMigrationInfo() {
        return flyway.info().all();
    }

    public void migrate() {
        MigrationInfo[] migrationInfo = getMigrationInfo();
        if (migrationInfo.length == 0) {
            setBaseline();
        }

        executeMigration();
    }

    private void executeMigration() {
        try {
            flyway.migrate();
        } catch (FlywayException e) {
            log.error("Migration failed: {}", e.getMessage());
            throw new RuntimeException("Migration failed", e);
        } catch (Exception e) {
            log.error("Unexpected error during migration: {}", e.getMessage());
            throw new RuntimeException("Unexpected error during migration", e);
        }
    }



}
