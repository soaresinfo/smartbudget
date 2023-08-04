package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.mapper.TransactionMapper;
import com.soares.smartbudget.repository.TransactionRepository;
import com.soares.smartbudget.repository.entity.TransactionEntity;
import com.soares.smartbudget.service.core.Transaction;
import com.soares.smartbudget.service.gateway.FindAllTransactionsByDateGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Component
public class FindAllTransactionsByDateDataProvider implements FindAllTransactionsByDateGateway {

    private final TransactionRepository repository;

    public List<Transaction> findByTransactionDate(LocalDate start, LocalDate end) {

        List<TransactionEntity> list = repository.findByTransactionDateBetween(start, end);
        return TransactionMapper.INSTANCE.fromEntityToCore(list);
    }
}
