package com.soares.smartbudget.service.gateway;

import com.soares.smartbudget.service.core.Income;

import java.time.LocalDate;
import java.util.List;

public interface FindIncomeGateway {

    List<Income> findAllByIncomeDateBetween(LocalDate startDate, LocalDate endDate);
}
