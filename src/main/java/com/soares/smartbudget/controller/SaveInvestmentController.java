package com.soares.smartbudget.controller;

import com.soares.smartbudget.controller.exception.BadRequestException;
import com.soares.smartbudget.controller.model.InvestmentRequestModel;
import com.soares.smartbudget.controller.model.InvestmentResponseModel;
import com.soares.smartbudget.controller.validator.InvestmentRequestValidator;
import com.soares.smartbudget.mapper.InvestmentMapper;
import com.soares.smartbudget.service.SaveInvestmentService;
import com.soares.smartbudget.service.core.Investment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class SaveInvestmentController {

    private final SaveInvestmentService service;
    private final InvestmentRequestValidator validator;
    private final InvestmentMapper mapper = InvestmentMapper.INSTANCE;

    @PostMapping(path = "/investments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvestmentResponseModel> save(@RequestBody InvestmentRequestModel model) {

        boolean isCreation = !StringUtils.hasText(model.getIdInvestment());
        if (isCreation) {
            model.setIdInvestment(null);
        }

        validator.validate(model).isInvalidThrow(BadRequestException.class);

        Investment savedInvestment = service.save(mapper.fromModelToCore(model));

        // Retorna a resposta HTTP apropriada: 201 Created para novas criações, 200 OK para atualizações.
        HttpStatus status = isCreation ? HttpStatus.CREATED : HttpStatus.OK;
        return ResponseEntity.status(status).body(mapper.fromCoreToModel(savedInvestment));
    }
}