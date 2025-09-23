package com.soares.smartbudget.dataprovider.database;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import com.soares.smartbudget.dataprovider.exception.TechnicalException;
import com.soares.smartbudget.mapper.InvestmentMapper;
import com.soares.smartbudget.repository.InvestmentRepository;
import com.soares.smartbudget.repository.entity.InvestmentEntity;
import com.soares.smartbudget.service.core.Investment;
import com.soares.smartbudget.service.gateway.SaveInvestmentGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class SaveInvestmentDataProvider implements SaveInvestmentGateway {

    private final InvestmentRepository repository;
    private final InvestmentMapper mapper = InvestmentMapper.INSTANCE;

    @Override
    public Investment save(Investment investment) {
        log.info("DataProvider: Iniciando salvamento do investimento: {}", investment);

        InvestmentEntity entity = mapper.fromCoreToEntity(investment);

        try {
            InvestmentEntity savedEntity = repository.save(entity);
            log.info("DataProvider: Investimento salvo com sucesso: {}", savedEntity);

            return mapper.fromEntityToCore(savedEntity);
        } catch (Exception exception) {
            String errorMessage = String.format("Falha ao salvar investimento: %s", exception.getMessage());
            log.error(errorMessage, exception);

            ValidationResult validation = ValidationResult.fail(List.of(Error.create(
                    "investment",
                    errorMessage,
                    String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                    entity)));

            throw new TechnicalException(validation);
        }
    }
}