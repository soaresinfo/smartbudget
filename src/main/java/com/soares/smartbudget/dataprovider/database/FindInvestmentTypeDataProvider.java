package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.mapper.InvestmentTypeMapper;
import com.soares.smartbudget.repository.InvestmentTypeRepository;
import com.soares.smartbudget.service.core.InvestmentType;
import com.soares.smartbudget.service.gateway.FindInvestmentTypeGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RequiredArgsConstructor
@Component
public class FindInvestmentTypeDataProvider implements FindInvestmentTypeGateway {

    private final InvestmentTypeRepository investmentTypeRepository;

    private final InvestmentTypeMapper investmentTypeMapper = InvestmentTypeMapper.INSTANCE;

    @Override
    public List<InvestmentType> findAllInvestmentTypes() {
        log.info("Starting to find all investmentType.");
        try {
            log.debug("Searching for locations");
            var listInvestmentTypeEntity = investmentTypeRepository.findAll();
            List<InvestmentType> listInvestmentType = StreamSupport
                    .stream(listInvestmentTypeEntity.spliterator(), false)
                    .map(investmentTypeMapper::fromEntityToCore)
                    .collect(Collectors.toList());

            if (listInvestmentType.isEmpty()) {
                log.info("No locations found.");
                return Collections.emptyList();
            }

            log.info("Successfully found {} locations for the current month.", listInvestmentType.size());
            return listInvestmentType;
        } catch (Exception e) {
            log.error("Error finding investments.", e);
            return Collections.emptyList();
        }
    }

}
