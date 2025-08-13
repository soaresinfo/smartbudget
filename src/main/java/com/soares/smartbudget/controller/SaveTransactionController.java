package com.soares.smartbudget.controller;

import com.soares.smartbudget.controller.exception.BadRequestException;
import com.soares.smartbudget.controller.model.TransactionRequestModel;
import com.soares.smartbudget.controller.model.TransactionResponseModel;
import com.soares.smartbudget.controller.validator.TransactionRequestValidator;
import com.soares.smartbudget.mapper.TransactionMapper;
import com.soares.smartbudget.service.SaveTransactionService;
import com.soares.smartbudget.service.core.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class SaveTransactionController {

    private final SaveTransactionService service;

    private final TransactionRequestValidator validator;

    @PostMapping(path = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionResponseModel> save(@RequestBody TransactionRequestModel model) {

        validator.validate(model).isInvalidThrow(BadRequestException.class);
        Transaction response = service.save(TransactionMapper.INSTANCE.fromModelToCore(model));
        return ResponseEntity.accepted().body(TransactionMapper.INSTANCE.fromCoreToModel(response));
    }
}
