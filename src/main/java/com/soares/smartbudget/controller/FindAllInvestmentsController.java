package com.soares.smartbudget.controller;

import com.soares.smartbudget.controller.exception.BadRequestException;
import com.soares.smartbudget.controller.model.InvestmentResponseModel;
import com.soares.smartbudget.controller.validator.DateValidator;
import com.soares.smartbudget.mapper.InvestmentMapper;
import com.soares.smartbudget.service.core.Investment;
import com.soares.smartbudget.service.gateway.FindAllInvestmentsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class FindAllInvestmentsController {

    private final FindAllInvestmentsGateway gateway;

    private final DateValidator validator = new DateValidator("date");

    @GetMapping(path = "/investments", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<InvestmentResponseModel>> findAllInvestmentsByMonth(@RequestParam("startDate") String startDate,
                                                                                   @RequestParam("endDate") String endDate){
        validator.validate(startDate).isInvalidThrow(BadRequestException.class);
        validator.validate(endDate).isInvalidThrow(BadRequestException.class);
        List<Investment> response = gateway.findAllInvestmentsByMonth(LocalDate.parse(startDate), LocalDate.parse(endDate));

        return ResponseEntity.ok(InvestmentMapper.INSTANCE.fromCoreToModel(response));
    }
}
