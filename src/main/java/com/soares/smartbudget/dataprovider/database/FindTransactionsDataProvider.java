package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.mapper.TransactionMapper;
import com.soares.smartbudget.repository.TransactionRepository;
import com.soares.smartbudget.repository.entity.TransactionEntity;
import com.soares.smartbudget.service.core.Transaction;
import com.soares.smartbudget.service.gateway.FindTransactionsGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindTransactionsDataProvider implements FindTransactionsGateway {

    private final TransactionRepository repository;

    @Override
    public List<Transaction> findByTransactionDate(LocalDate start, LocalDate end) {
        log.info("DataProvider: Buscando transações entre as datas: início={}, fim={}", start, end);

        List<TransactionEntity> list = repository.findByTransactionDateBetween(start, end);
        log.info("DataProvider: {} transaçōes encontradas no banco de dados.", list.size());

        return TransactionMapper.INSTANCE.fromEntityToCore(list);
    }
}