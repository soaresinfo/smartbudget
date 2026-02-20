package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.mapper.ExpenseMapper;
import com.soares.smartbudget.repository.entity.CategoryEntity;
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
        log.info("Iniciando busca por todas as categorias no banco de dados.");
        var expenseEntities = repository.findAll();
        List<Expense> expenseList = StreamSupport
                .stream(expenseEntities.spliterator(), false)
                .map(mapper::fromEntityToCore)
                .collect(Collectors.toList());

        log.info("Busca finalizada. {} categorias encontradas.", expenseList.size());

        return expenseList;
    }

    @Override
    public List<Expense> findCategoriesByParentId(Long parentId) {
        log.info("Iniciando busca por subcategorias com parentId {}.", parentId.toString());
        var expenseEntities = repository.findCategoriesByParent(CategoryEntity.builder().idCategory(parentId).build());
        List<Expense> expenseList = StreamSupport
                .stream(expenseEntities.spliterator(), false)
                .map(mapper::fromEntityToCore)
                .collect(Collectors.toList());

        log.info("Busca finalizada. {} subcategorias encontradas.", expenseList.size());

        return expenseList;
    }

    @Override
    public List<Expense> findMainCategories() {
        log.info("Iniciando busca por todas as principais categorias no banco de dados.");
        var expenseEntities = repository.findByParentIsNull();
        List<Expense> expenseList = StreamSupport
                .stream(expenseEntities.spliterator(), false)
                .map(mapper::fromEntityToCore)
                .collect(Collectors.toList());

        log.info("Busca finalizada. {} categorias encontradas.", expenseList.size());

        return expenseList;
    }
}
