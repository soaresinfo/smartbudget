package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Transaction;
import com.soares.smartbudget.service.gateway.SaveTransactionGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveTransactionService {

    private final SaveTransactionGateway gateway;

    public Transaction save(Transaction transaction) {
        return gateway.save(transaction);
    }
}
