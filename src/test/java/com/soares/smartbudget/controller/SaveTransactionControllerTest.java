package com.soares.smartbudget.controller;

import br.com.fluentvalidator.context.Error;
import com.soares.smartbudget.controller.exception.BadRequestException;
import com.soares.smartbudget.controller.model.TransactionRequestModel;
import com.soares.smartbudget.controller.model.TransactionResponseModel;
import com.soares.smartbudget.controller.validator.TransactionRequestValidator;
import com.soares.smartbudget.factory.TransactionFactory;
import com.soares.smartbudget.mapper.TransactionMapper;
import com.soares.smartbudget.service.SaveTransactionService;
import com.soares.smartbudget.service.core.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static com.soares.smartbudget.controller.model.TransactionRequestModel.TRANSACTION_DATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SaveTransactionControllerTest {

    @InjectMocks
    private SaveTransactionController controller;

    @Mock
    private SaveTransactionService service;

    @Spy
    private TransactionRequestValidator validator;

    @Test
    void testSaveTransactionSuccessReturnsTransaction(){
        TransactionRequestModel model = TransactionFactory.getModel();
        Transaction transaction = TransactionMapper.INSTANCE.fromModelToCore(model);
        Transaction transactionSaved = buildTransaction(transaction);

        when(service.save(eq(transaction))).thenReturn(transactionSaved);

        ResponseEntity<TransactionResponseModel> response = controller.save(model);

        verify(validator, times(1)).validate(eq(model));
        verify(service, only()).save(eq(transaction));

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        assertThat(response.getBody()).isNotNull()
                .hasNoNullFieldsOrProperties()
                .extracting(TransactionResponseModel::getIdTransaction,
                            TransactionResponseModel::getDescription,
                            TransactionResponseModel::getTransactionDate,
                            TransactionResponseModel::getValue)
                .containsExactly(transactionSaved.idTransaction().toString(),
                                 transactionSaved.description(),
                                 transactionSaved.transactionDate().format(DateTimeFormatter.ISO_DATE),
                                 transactionSaved.value().toString());
    }

    @Test
    void testSaveTransactionFailOnValidatorReturnsBadRequest(){
        TransactionRequestModel model = TransactionFactory.getModel();
        model.setTransactionDate(null);

        BadRequestException bre = assertThrows(BadRequestException.class,
                () -> controller.save(model));

        verify(validator, times(1)).validate(eq(model));
        verify(service, never()).save(any(Transaction.class));

        assertThat(bre).isNotNull();
        assertThat(bre.getValidationResult().getErrors()).hasSize(1);

        Error error = bre.getValidationResult().getErrors().stream().findFirst().get();
        assertThat(error.getField()).isEqualTo(TRANSACTION_DATE);
        assertThat(error.getMessage()).isEqualTo(String.format(TransactionRequestValidator.MSG_NULO_OU_VAZIO, TRANSACTION_DATE));
    }

    private Transaction buildTransaction(Transaction core){
        return new Transaction(UUID.randomUUID(), core.value(), core.description(), core.transactionDate(), core.expense());
    }

    @Test
    void testSaveTransactionFailOnServiceReturnsException(){
        TransactionRequestModel model = TransactionFactory.getModel();
        Transaction transaction = TransactionMapper.INSTANCE.fromModelToCore(model);

        when(service.save(eq(transaction))).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class,
                () -> controller.save(model));

        verify(validator, times(1)).validate(eq(model));
        verify(service, times(1)).save(any(Transaction.class));
    }
}
