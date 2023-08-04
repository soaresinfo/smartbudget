package com.soares.smartbudget;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(scripts = {"classpath:schema.sql", "classpath:data.sql"})
public abstract class AbstractIntegrationTest {

    @Container
    public static MySQLContainer container = new MySQLContainer("mysql:latest")
            .withDatabaseName("budget")
            .withUsername("root")
            .withPassword("root");

    @BeforeAll
    static void setup(){
        container.withReuse(true);
        container.start();
    }

    @AfterAll
    public static void tearDown() {
        container.stop();
    }

    @DynamicPropertySource
    public static void overrideProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.driver-class-name", container::getDriverClassName);
        registry.add("spring.jpa.properties.hibernate.show-sql", Boolean.TRUE::booleanValue);
    }
}
