package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.mapper.ExpenseMapper;
import com.soares.smartbudget.repository.security.ExpenseRepository;
import com.soares.smartbudget.service.core.Expense;
import com.soares.smartbudget.service.gateway.FindExpenseGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindExpenseDataProvider implements FindExpenseGateway {

    private final ExpenseRepository repository;

    private final ExpenseMapper mapper = ExpenseMapper.INSTANCE;

    @Override
    public List<Expense> findAll() {
        log.info("Iniciando busca por todas as despesas no banco de dados.");
        var expenseEntities = repository.findAll();
        List<Expense> expenseList = StreamSupport
                .stream(expenseEntities.spliterator(), false)
                .map(mapper::fromEntityToCore)
                .collect(Collectors.toList());

        log.info("Busca finalizada. {} despesas encontradas.", expenseList.size());

        return expenseList;
    }
}
