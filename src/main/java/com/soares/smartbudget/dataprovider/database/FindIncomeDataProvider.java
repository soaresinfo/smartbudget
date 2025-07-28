package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.mapper.IncomeMapper;
import com.soares.smartbudget.repository.IncomeRepository;
import com.soares.smartbudget.repository.entity.IncomeEntity;
import com.soares.smartbudget.service.core.Income;
import com.soares.smartbudget.service.gateway.FindIncomeGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindIncomeDataProvider implements FindIncomeGateway {

    private final IncomeRepository repository;

    private final IncomeMapper mapper = IncomeMapper.INSTANCE;
    @Override
    public List<Income> findAllByIncomeDateBetween(LocalDate startDate, LocalDate endDate) {
        log.info("Starting to find all incomes between dates {} and {}.", startDate, endDate);
        try {
            log.debug("Searching for incomes with income_date between {} and {}", startDate, endDate);
            List<IncomeEntity> incomeEntities = repository.findAllByIncomeDateBetween(startDate, endDate);

            if (incomeEntities.isEmpty()) {
                log.info("No incomes found for the period between {} and {}.", startDate, endDate);
                return Collections.emptyList();
            }

            List<Income> incomes = mapper.fromEntityToCore(incomeEntities);

            log.info("Successfully found {} incomes for the specified period.", incomes.size());
            return incomes;

        } catch (Exception e) {
            log.error("Error finding incomes for the period between {} and {}.", startDate, endDate, e);
            return Collections.emptyList();
        }
    }
}