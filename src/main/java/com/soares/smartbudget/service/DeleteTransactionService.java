package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Transaction;
import com.soares.smartbudget.service.gateway.DeleteTransactionGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteTransactionService {

    private final DeleteTransactionGateway gateway;

    public void delete(Transaction transaction) {
        gateway.delete(transaction);
    }
}
