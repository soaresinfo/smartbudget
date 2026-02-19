package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.InvestmentType;
import com.soares.smartbudget.service.gateway.FindInvestmentTypeGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindInvestmentTypeService {

    private final FindInvestmentTypeGateway gateway;

    public List<InvestmentType> findAll(){
        return gateway.findAllInvestmentTypes();
    }

}
