package com.soares.smartbudget.controller;

import com.soares.smartbudget.AbstractIntegrationTest;
import com.soares.smartbudget.controller.model.TransactionResponseModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindTransactionsControllerIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private FindTransactionsController controller;

    @Test
    void testFindAllTransactionsByDateReturnsResponseWithTwoTransactions(){
        LocalDate date = LocalDate.now();
        String transactionDate = date.format(DateTimeFormatter.ISO_DATE);

        ResponseEntity<List<TransactionResponseModel>> response = controller.findAllByDate(transactionDate);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty()
                .hasSize(2)
                .extracting(TransactionResponseModel::getTransactionDate,
                            TransactionResponseModel::getExpense,
                            TransactionResponseModel::getIdTransaction,
                            TransactionResponseModel::getDescription,
                            TransactionResponseModel::getValue)
                .doesNotContainNull();
    }
}
