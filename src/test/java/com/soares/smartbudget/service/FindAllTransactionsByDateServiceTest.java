package com.soares.smartbudget.service;

import com.soares.smartbudget.AbstractIntegrationTest;
import com.soares.smartbudget.service.core.Transaction;
import com.soares.smartbudget.service.gateway.FindAllTransactionsByDateGateway;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAllTransactionsByDateServiceTest extends AbstractIntegrationTest {

    @Autowired
    private FindAllTransactionsByDateGateway gateway;

    @Spy
    private FakeService fakeService;

    @Test
    void testFindAllTransactionsByDateReturnListWithTwo(){
        LocalDate date = LocalDate.now();
        LocalDate start = date.withDayOfMonth(1);
        LocalDate end = date.withDayOfMonth(date.lengthOfMonth());
        FindAllTransactionsByDateService service = new FindAllTransactionsByDateService(gateway, fakeService);

        List<Transaction> response = service.findAllByDate(date);

        Mockito.verify(fakeService, Mockito.times(1)).save();

        assertThat(response).isNotNull()
                .hasSize(2)
                .extracting(Transaction::transactionDate)
                .allMatch(dt -> dt.isAfter(start) && dt.isBefore(end));
    }
}
