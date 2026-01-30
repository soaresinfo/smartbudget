package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Expense;
import com.soares.smartbudget.service.gateway.FindExpenseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FindExpenseService {

    private final FindExpenseGateway gateway;

    public List<Expense> findAll(){
        return gateway.findAll();
    }

    public List<Expense> findMainCategories(){
        return gateway.findMainCategories();
    }

    public List<Expense> findCategoriesByParentId(UUID parentId){
        return gateway.findCategoriesByParentId(parentId);
    }
}
