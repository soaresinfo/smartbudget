package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.AbstractIntegrationTest;
import com.soares.smartbudget.factory.TransactionFactory;
import com.soares.smartbudget.repository.entity.TransactionEntity;
import com.soares.smartbudget.service.core.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindTransactionsDataProviderTest extends AbstractIntegrationTest {

    @Autowired
    private FindTransactionsDataProvider dataProvider;

    @Test
    void testFindAllByDateReturnsList(){
        LocalDate date = LocalDate.now();
        LocalDate start = date.withDayOfMonth(1);
        LocalDate end = date.withDayOfMonth(date.lengthOfMonth());
        List<TransactionEntity> list = Arrays.asList(TransactionFactory.getEntity());


        List<Transaction> response = dataProvider.findByTransactionDate(start, end);

        assertThat(response).isNotNull()
                .isNotEmpty()
                .hasSize(2)
                .extracting(Transaction::transactionDate)
                .allMatch(dt -> dt.isAfter(start) && dt.isBefore(end));
    }


    @Test
    void testFindAllByDateReturnsEmptyList(){
        LocalDate date = LocalDate.MIN;
        LocalDate start = date.withDayOfMonth(1);
        LocalDate end = date.withDayOfMonth(date.lengthOfMonth());
        List<TransactionEntity> list = Arrays.asList(TransactionFactory.getEntity());

        List<Transaction> response = dataProvider.findByTransactionDate(start, end);

        assertThat(response).isNotNull()
                .isEmpty();
    }
}
