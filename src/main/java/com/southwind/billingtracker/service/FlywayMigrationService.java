package com.southwind.billingtracker.service;

import com.southwind.billingtracker.config.flyway.FlywayConfiguration;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayMigrationService {

    private Flyway flyway;

    @Autowired
    public FlywayMigrationService(FlywayConfiguration flywayConfiguration){
        this.flyway = Flyway.configure().dataSource(flywayConfiguration.getUrl(),flywayConfiguration.getUsername(),flywayConfiguration.getPassword()).load();
    }
    public void migrate() {
        flyway.migrate();
    }

}
