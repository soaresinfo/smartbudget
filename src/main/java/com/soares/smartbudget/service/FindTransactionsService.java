package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Transaction;
import com.soares.smartbudget.service.gateway.FindTransactionsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FindTransactionsService {

    private final FindTransactionsGateway gateway;

    private final FakeService fakeService;

    public List<Transaction> findAllByDate(LocalDate date) {
        LocalDate start = date.withDayOfMonth(1);
        LocalDate end = date.withDayOfMonth(date.lengthOfMonth());
        fakeService.save();
        return gateway.findByTransactionDate(start, end);
    }
}
