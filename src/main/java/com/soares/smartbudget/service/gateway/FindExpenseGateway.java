package com.soares.smartbudget.service.gateway;

import com.soares.smartbudget.service.core.Expense;

import java.util.List;
import java.util.UUID;

public interface FindExpenseGateway {

    List<Expense> findAll();

    List<Expense> findMainCategories();

    List<Expense> findCategoriesByParentId(UUID parentId);
}
