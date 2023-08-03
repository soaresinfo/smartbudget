package com.soares.smartbudget.service;

import com.soares.smartbudget.factory.TransactionFactory;
import com.soares.smartbudget.service.core.Transaction;
import com.soares.smartbudget.service.gateway.SaveTransactionGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SaveTransactionServiceTest {

    @InjectMocks
    private SaveTransactionService service;

    @Mock
    private SaveTransactionGateway gateway;

    @Test
    void testSaveTransactionSuccessReturnTransaction(){
        Transaction core = TransactionFactory.getCore();
        Transaction coreSaved = getNewCore(core);

        when(gateway.save(eq(core))).thenReturn(coreSaved);

        Transaction response = service.save(core);

        verify(gateway, times(1)).save(eq(core));

        assertThat(response).isNotNull()
                .hasNoNullFieldsOrProperties()
                .extracting(Transaction::value,
                            Transaction::description,
                            Transaction::transactionDate)
                .containsExactly(core.value(),
                                 core.description(),
                                 core.transactionDate());
    }

    @Test
    void testSaveTransactionThrowsException(){
        Transaction core = TransactionFactory.getCore();

        when(gateway.save(eq(core))).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class,
                () -> service.save(core));

        verify(gateway, times(1)).save(eq(core));
    }

    private Transaction getNewCore(Transaction core){
        return new Transaction(UUID.randomUUID(), core.value(), core.description(), core.transactionDate(), core.expense());
    }
}
