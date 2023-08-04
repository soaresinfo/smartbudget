package com.soares.smartbudget.controller;

import com.soares.smartbudget.AbstractIntegrationTest;
import com.soares.smartbudget.controller.model.TransactionRequestModel;
import com.soares.smartbudget.controller.model.TransactionResponseModel;
import com.soares.smartbudget.factory.TransactionFactory;
import com.soares.smartbudget.mapper.TransactionMapper;
import com.soares.smartbudget.service.core.Transaction;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class SaveTransactionControllerIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private SaveTransactionController controller;

    @Test
    void testSaveTransactionSuccess(){
        TransactionRequestModel model = TransactionFactory.getModel();
        model.setIdExpense("c96adcca-00d5-49da-9261-dcbd0156d064");
        Transaction transaction = TransactionMapper.INSTANCE.fromModelToCore(model);

        ResponseEntity<TransactionResponseModel> response = controller.save(model);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        assertThat(response.getBody()).isNotNull()
                .hasNoNullFieldsOrProperties()
                .extracting(TransactionResponseModel::getDescription,
                        TransactionResponseModel::getTransactionDate,
                        TransactionResponseModel::getValue)
                .containsExactly(model.getDescription(),
                                 model.getTransactionDate(),
                                 model.getValue());

    }

}
