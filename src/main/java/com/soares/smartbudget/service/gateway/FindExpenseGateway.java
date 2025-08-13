package com.soares.smartbudget.service.gateway;

import com.soares.smartbudget.service.core.Expense;

import java.util.List;

public interface FindExpenseGateway {

    List<Expense> findAll();
}
