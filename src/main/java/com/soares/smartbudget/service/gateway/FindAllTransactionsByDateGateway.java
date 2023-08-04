package com.soares.smartbudget.service.gateway;

import com.soares.smartbudget.service.core.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface FindAllTransactionsByDateGateway {

    List<Transaction> findByTransactionDate(LocalDate start, LocalDate end);
}
