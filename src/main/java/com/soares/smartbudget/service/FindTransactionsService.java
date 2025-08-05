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

    public List<Transaction> findAllByDate(LocalDate startDate, LocalDate endDate) {
        return gateway.findByTransactionDate(startDate, endDate);
    }
}
