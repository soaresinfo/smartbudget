package com.soares.smartbudget;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MySQLContainer;

public class ContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    // 1. O container é declarado como um singleton estático.
    static final MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.33")
            .withDatabaseName("budget")
            .withUsername("root")
            .withPassword("root")
            .withInitScript("schema.sql")
            .withReuse(true);

    static {
        mysqlContainer.start();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        TestPropertyValues.of(
                "spring.datasource.url=" + mysqlContainer.getJdbcUrl(),
                "spring.datasource.username=" + mysqlContainer.getUsername(),
                "spring.datasource.password=" + mysqlContainer.getPassword(),
                "spring.datasource.driver-class-name=" + mysqlContainer.getDriverClassName()
        ).applyTo(applicationContext.getEnvironment());
    }
}