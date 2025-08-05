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
import java.util.List;

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
}
