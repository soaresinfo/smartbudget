package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.factory.TransactionFactory;
import com.soares.smartbudget.repository.TransactionRepository;
import com.soares.smartbudget.repository.entity.TransactionEntity;
import com.soares.smartbudget.service.core.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindTransactionsDataProviderTest {

    @InjectMocks
    private FindTransactionsDataProvider dataProvider;

    @Mock
    private TransactionRepository repository;

    @Test
    void testFindAllByDateReturnsList(){
        LocalDate date = LocalDate.now();
        LocalDate start = date.withDayOfMonth(1);
        LocalDate end = date.withDayOfMonth(date.lengthOfMonth());
        List<TransactionEntity> list = Arrays.asList(TransactionFactory.getEntity());

        when(repository.findByTransactionDateBetween(start, end)).thenReturn(list);

        List<Transaction> response = dataProvider.findByTransactionDate(start, end);

        assertThat(response).isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .extracting(Transaction::transactionDate)
                .allMatch(dt -> dt.isAfter(start) && dt.isBefore(end));
    }


    @Test
    void testFindAllByDateReturnsEmptyList(){
        LocalDate date = LocalDate.MIN;
        LocalDate start = date.withDayOfMonth(1);
        LocalDate end = date.withDayOfMonth(date.lengthOfMonth());
        List<TransactionEntity> list = Arrays.asList();
        when(repository.findByTransactionDateBetween(start, end)).thenReturn(list);
        List<Transaction> response = dataProvider.findByTransactionDate(start, end);

        assertThat(response).isNotNull()
                .isEmpty();
    }
}
