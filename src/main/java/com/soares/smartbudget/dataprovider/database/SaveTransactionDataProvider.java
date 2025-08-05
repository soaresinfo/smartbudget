package com.soares.smartbudget.dataprovider.database;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import com.soares.smartbudget.dataprovider.exception.TechnicalException;
import com.soares.smartbudget.mapper.TransactionMapper;
import com.soares.smartbudget.repository.TransactionRepository;
import com.soares.smartbudget.repository.entity.TransactionEntity;
import com.soares.smartbudget.service.core.Transaction;
import com.soares.smartbudget.service.gateway.SaveTransactionGateway;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SaveTransactionDataProvider implements SaveTransactionGateway {

    private final TransactionRepository repository;

    private final Logger logger = LoggerFactory.getLogger(SaveTransactionDataProvider.class);

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity entity = TransactionMapper.INSTANCE.fromCoreToEntity(transaction);
        try {
            TransactionEntity response = repository.save(entity);
            return TransactionMapper.INSTANCE.fromEntityToCore(response);
        }
        catch (Exception exception){
            String errorMessage = String.format("Falha ao salvar transação: %s", exception.getMessage());
            logger.error(errorMessage);
            ValidationResult validation = ValidationResult.fail(List.of(Error.create(null, errorMessage,
                    String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), entity)));
            throw new TechnicalException(validation);
        }

    }
}
