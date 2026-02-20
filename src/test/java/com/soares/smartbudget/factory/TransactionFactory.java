package com.soares.smartbudget.factory;

import com.github.javafaker.Faker;
import com.soares.smartbudget.controller.model.TransactionRequestModel;
import com.soares.smartbudget.repository.entity.CategoryEntity;
import com.soares.smartbudget.repository.entity.TransactionEntity;
import com.soares.smartbudget.service.core.Category;
import com.soares.smartbudget.service.core.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TransactionFactory {

    private static final Faker FAKER = FakerFactory.getInstance();
    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static TransactionRequestModel getModel(){
        return TransactionRequestModel.builder()
                .description(FAKER.commerce().productName())
                .transactionDate(LocalDate.now().format(formatter))
                .value(FAKER.numerify("#.##"))
                .idCategory(UUID.randomUUID().toString())
                .build();
    }

    public static Transaction getCore() {
        return new Transaction(null, BigDecimal.TEN, FAKER.commerce().productName(),LocalDate.now(), new Category(1L, null, null, null), 1, 1 );
    }

    public static Transaction getCoreFull() {
        return new Transaction(1L, BigDecimal.TEN, FAKER.commerce().productName(),LocalDate.now(),
                new Category(1L, BigDecimal.TEN, FAKER.commerce().material(),
                        new Category(1L, BigDecimal.TEN, FAKER.commerce().material(), null)), 1, 1 );
    }

    public static TransactionEntity getEntity() {
        return TransactionEntity.builder()
                .description(FAKER.commerce().productName())
                .value(BigDecimal.TEN)
                .transactionDate(LocalDate.now())
                .category(CategoryEntity.builder().idCategory(1L).build())
                .build();
    }
}

