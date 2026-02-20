package com.soares.smartbudget.controller;

import com.soares.smartbudget.controller.exception.BadRequestException;
import com.soares.smartbudget.controller.model.TransactionRequestModel;
import com.soares.smartbudget.controller.validator.TransactionRequestValidator;
import com.soares.smartbudget.mapper.TransactionMapper;
import com.soares.smartbudget.service.DeleteTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class DeleteTransactionController {

    private final DeleteTransactionService service;

    private final TransactionRequestValidator validator;

    @DeleteMapping(path = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@RequestBody TransactionRequestModel model) {

        validator.validate(model).isInvalidThrow(BadRequestException.class);
        service.delete(TransactionMapper.INSTANCE.fromModelToCore(model));

        return ResponseEntity.noContent().build();
    }
}
