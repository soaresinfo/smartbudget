package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Transaction;
import com.soares.smartbudget.service.gateway.SaveTransactionGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class SaveTransactionService {

    private final SaveTransactionGateway gateway;

    public Transaction save(Transaction transaction) {
        Transaction response = null;
        LocalDate transactionDate = transaction.transactionDate();
        for (int installment = 1; installment <= transaction.installmentTotal(); installment++) {
            response = gateway.save(buildTransactionInstallment(transaction, installment, transactionDate));
            transactionDate = nextInstallmentDate(transactionDate);
        }
        return response;
    }

    private Transaction buildTransactionInstallment(Transaction transaction, Integer installmentNumber, LocalDate transactionDate) {
        //crie um novo objeto transaction com o novo parametro installmentNumber) {
        return new Transaction(
                transaction.idTransaction(),
                transaction.value(),
                transaction.description(),
                transactionDate,
                transaction.category(),
                installmentNumber,
                transaction.installmentTotal()
        );
    }

    private LocalDate nextInstallmentDate(LocalDate transactionDate) {
        return transactionDate.plusMonths(1).withDayOfMonth(1);
    }


}
