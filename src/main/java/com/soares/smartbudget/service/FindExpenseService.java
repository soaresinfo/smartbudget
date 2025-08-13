package com.soares.smartbudget.service;

import com.soares.smartbudget.service.core.Expense;
import com.soares.smartbudget.service.gateway.FindExpenseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindExpenseService {

    private final FindExpenseGateway gateway;

    public List<Expense> findAll(){
        return gateway.findAll();
    }
}
