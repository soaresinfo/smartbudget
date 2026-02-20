package com.soares.smartbudget.service.gateway;

import com.soares.smartbudget.service.core.Transaction;

public interface DeleteTransactionGateway {
    void delete(Transaction transaction);
}
