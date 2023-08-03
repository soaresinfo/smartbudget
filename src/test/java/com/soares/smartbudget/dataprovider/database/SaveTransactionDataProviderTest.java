package com.soares.smartbudget.dataprovider.database;

import com.soares.smartbudget.dataprovider.exception.TechnicalException;
import com.soares.smartbudget.factory.TransactionFactory;
import com.soares.smartbudget.mapper.TransactionMapper;
import com.soares.smartbudget.repository.TransactionRepository;
import com.soares.smartbudget.repository.entity.TransactionEntity;
import com.soares.smartbudget.service.core.Transaction;
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
public class SaveTransactionDataProviderTest {

    @InjectMocks
    private SaveTransactionDataProvider dataProvider;

    @Mock
    private TransactionRepository repository;

    @Test
    void testSaveTransactionSuccess(){
        Transaction core = TransactionFactory.getCore();
        TransactionEntity entity = TransactionMapper.INSTANCE.fromCoreToEntity(core);
        TransactionEntity entitySaved = TransactionMapper.INSTANCE.fromCoreToEntity(core);
        entitySaved.setIdTransaction(UUID.randomUUID());

        when(repository.save(eq(entity))).thenReturn(entitySaved);

        Transaction response = dataProvider.save(core);

        verify(repository, only()).save(eq(entity));

        assertThat(response).isNotNull()
                .hasNoNullFieldsOrProperties()
                .extracting(Transaction::idTransaction,
                            Transaction::transactionDate,
                            Transaction::value,
                            Transaction::description)
                .containsExactly(entitySaved.getIdTransaction(),
                                 entitySaved.getTransactionDate(),
                                 entitySaved.getValue(),
                                 entitySaved.getDescription());


    }

    @Test
    void testSaveTransactionThrowsInternalException(){
        Transaction core = TransactionFactory.getCore();
        TransactionEntity entity = TransactionMapper.INSTANCE.fromCoreToEntity(core);

        when(repository.save(eq(entity))).thenThrow(RuntimeException.class);

        TechnicalException te = assertThrows(TechnicalException.class,
                () -> dataProvider.save(core));

        verify(repository, only()).save(eq(entity));

        assertThat(te).isNotNull();
        assertThat(te.getValidationResult().getErrors()).isNotEmpty();
    }
}
