package com.soares.smartbudget.controller;

import com.soares.smartbudget.controller.model.ExpenseResponseModel;
import com.soares.smartbudget.mapper.ExpenseMapper;
import com.soares.smartbudget.service.FindExpenseService;
import com.soares.smartbudget.service.core.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class FindExpenseController {

    private final FindExpenseService service;

    @GetMapping(path = "/expenses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExpenseResponseModel>> findAll(){
        List<Expense> expenses = service.findAll();
        return ResponseEntity.ok(ExpenseMapper.INSTANCE.fromCoreToModel(expenses));
    }
}
