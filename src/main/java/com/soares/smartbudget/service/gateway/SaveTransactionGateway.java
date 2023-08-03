package com.soares.smartbudget.service.gateway;

import com.soares.smartbudget.service.core.Transaction;

public interface SaveTransactionGateway {
    Transaction save(Transaction transaction);
}
