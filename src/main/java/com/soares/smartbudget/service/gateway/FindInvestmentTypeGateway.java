package com.soares.smartbudget.service.gateway;

import com.soares.smartbudget.service.core.InvestmentType;

import java.util.List;

public interface FindInvestmentTypeGateway {

    List<InvestmentType> findAllInvestmentTypes();

}
