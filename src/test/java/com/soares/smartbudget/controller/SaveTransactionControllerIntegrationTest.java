package com.soares.smartbudget.controller;

import com.soares.smartbudget.controller.model.TransactionRequestModel;
import com.soares.smartbudget.controller.model.TransactionResponseModel;
import com.soares.smartbudget.factory.TransactionFactory;
import com.soares.smartbudget.mapper.TransactionMapper;
import com.soares.smartbudget.service.core.Transaction;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@RequiredArgsConstructor
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(scripts = {"classpath:data.sql"})
public class SaveTransactionControllerIntegrationTest {

    @Autowired
    private SaveTransactionController controller;

    @Autowired
    EntityManager em;

    @Container
    public static MySQLContainer container = new MySQLContainer("mysql:latest")
            .withDatabaseName("budget")
            .withUsername("root")
            .withPassword("root");

    @BeforeAll
    static void setup(){
        container.withReuse(true);
        System.out.println("Gerando tabelas...");
        container.withInitScript("src/main/resources/data.sql");
        System.out.println("Tabelas geradas.");
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

    @Test
    void test(){
        TransactionRequestModel model = TransactionFactory.getModel();
        model.setIdExpense("c96adcca-00d5-49da-9261-dcbd0156d064");
        Transaction transaction = TransactionMapper.INSTANCE.fromModelToCore(model);

        ResponseEntity<TransactionResponseModel> response = controller.save(model);
        System.out.println(response.getBody());

    }

}
