package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.mapper.InvestmentMapper;
import com.soares.smartbudget.repository.InvestmentRepository;
import com.soares.smartbudget.repository.entity.InvestmentEntity;
import com.soares.smartbudget.service.core.Investment;
import com.soares.smartbudget.service.gateway.FindInvestmentsGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindInvestmentsDataProvider implements FindInvestmentsGateway {

    private final InvestmentRepository investmentRepository;

    private final InvestmentMapper investmentMapper = InvestmentMapper.INSTANCE;

    @Override
    public List<Investment> findAllInvestmentsByMonth(LocalDate startDate, LocalDate endDate) {
        String monthSearched = startDate.getMonth().name();
        String yearSearched = startDate.getYear() + "";
        log.info("Starting to find all investments for month {} year {}.", monthSearched, yearSearched);
        try {
            log.debug("Searching for investments with last_update_date between {} and {}", startDate, endDate);
            List<InvestmentEntity> listInvestmentEntity = investmentRepository.findAllByLastUpdateDateBetween(startDate, endDate);

            if (listInvestmentEntity.isEmpty()) {
                log.info("No investments found for month {}.", monthSearched);
                return Collections.emptyList();
            }

            List<Investment> investments = investmentMapper.fromEntityToCore(listInvestmentEntity);

            log.info("Successfully found {} investments for the current month.", investments.size());
            return investments;
        } catch (Exception e) {
            log.error("Error finding investments for month {}.", monthSearched, e);
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Investment> findInvestmentByPortfolioAndPreviousMonth(Investment investment) {
        LocalDate previousMonthStart = investment.lastUpdateDate().minusMonths(1).withDayOfMonth(1);
        LocalDate previousMonthEnd = previousMonthStart.withDayOfMonth(previousMonthStart.lengthOfMonth());
        String monthSearched = previousMonthStart.getMonth().name();
        String yearSearched = previousMonthStart.getYear() + "";
        log.info("Starting to find all investments for month {} year {}.", monthSearched, yearSearched);
        try {
            log.debug("Searching for lat investment for the month {}", monthSearched);
            List<InvestmentEntity> listInvestmentEntity = investmentRepository.findAllByIdPortfolioAndLastUpdateDateBetween(investment.idPortfolio(),previousMonthStart, previousMonthEnd);

            if (listInvestmentEntity.isEmpty()) {
                log.info("No investments found for month {}.", monthSearched);
                return Optional.empty();
            }

            return listInvestmentEntity.stream()
                    .max(Comparator.comparing(InvestmentEntity::getLastUpdateDate))
                    .map(investmentMapper::fromEntityToCore);
        } catch (Exception e) {
            log.error("Error finding investments for month {}.", monthSearched, e);
            return Optional.empty();
        }
    }
}
