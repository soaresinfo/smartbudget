package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.mapper.InvestmentMapper;
import com.soares.smartbudget.repository.InvestmentRepository;
import com.soares.smartbudget.repository.entity.InvestmentEntity;
import com.soares.smartbudget.service.core.Investment;
import com.soares.smartbudget.service.gateway.FindAllInvestmentsGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindAllInvestmentsDataProvider implements FindAllInvestmentsGateway {

    private final InvestmentRepository investmentRepository;

    private final InvestmentMapper investmentMapper = InvestmentMapper.INSTANCE;

    @Override
    public List<Investment> findAllInvestmentsByMonth(LocalDateTime startDate, LocalDateTime endDate) {
        log.info("Starting to find all investments for the current month.");
        try {
            List<InvestmentEntity> listInvestmentEntity = investmentRepository.findAllByLastUpdateDateBetween(startDate, endDate);

            if (listInvestmentEntity.isEmpty()) {
                log.info("No investments found for the current month.");
                return Collections.emptyList();
            }

            List<Investment> investments = investmentMapper.fromEntityToCore(listInvestmentEntity);

            log.info("Successfully found {} investments for the current month.", investments.size());
            return investments;
        } catch (Exception e) {
            log.error("Error finding investments for the current month.", e);
            return Collections.emptyList();
        }
    }
}
