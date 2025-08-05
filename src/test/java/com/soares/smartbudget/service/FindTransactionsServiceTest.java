package com.soares.smartbudget.service;

import com.soares.smartbudget.factory.TransactionFactory;
import com.soares.smartbudget.service.core.Transaction;
import com.soares.smartbudget.service.gateway.FindTransactionsGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindTransactionsServiceTest {

    @InjectMocks
    private FindTransactionsService service;

    @Mock
    private FindTransactionsGateway gateway;

    @Test
    void testFindAllTransactionsByDateReturnListWithTwo(){
        LocalDate date = LocalDate.now();
        LocalDate start = date.withDayOfMonth(1);
        LocalDate end = date.withDayOfMonth(date.lengthOfMonth());

        when(gateway.findByTransactionDate(start, end)).thenReturn(List.of(TransactionFactory.getCore()));
        List<Transaction> response = service.findAllByDate(start,end);

        assertThat(response).isNotNull()
                .hasSize(1)
                .extracting(Transaction::transactionDate)
                .allMatch(dt -> dt.isAfter(start) && dt.isBefore(end));
    }
}
