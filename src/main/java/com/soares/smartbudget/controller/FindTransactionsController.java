package com.soares.smartbudget.controller;

import com.soares.smartbudget.controller.exception.BadRequestException;
import com.soares.smartbudget.controller.model.TransactionResponseModel;
import com.soares.smartbudget.controller.validator.DateValidator;
import com.soares.smartbudget.mapper.TransactionMapper;
import com.soares.smartbudget.service.FindTransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class FindTransactionsController {

    private final FindTransactionsService service;

    private final DateValidator validator = new DateValidator("transactionDate");

    @GetMapping(path = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransactionResponseModel>> findAllByDate(@RequestParam("transactionDate") String transactionDate) {
        validator.validate(transactionDate).isInvalidThrow(BadRequestException.class);
        LocalDate date = LocalDate.parse(transactionDate, DateTimeFormatter.ISO_DATE);

        return ResponseEntity.ok(TransactionMapper.INSTANCE.fromCoreToModel(service.findAllByDate(date)));
    }
}
