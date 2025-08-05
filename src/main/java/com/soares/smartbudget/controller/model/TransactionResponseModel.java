package com.soares.smartbudget.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TransactionResponseModel {

    public static final String ID_TRANSACTION = "id_transaction";
    public static final String VALUE = "value";
    public static final String DESCRIPTION = "description";
    public static final String TRANSACTION_DATE = "transaction_date";
    public static final String EXPENSE = "expense";

    @JsonProperty(value = ID_TRANSACTION)
    private String idTransaction;

    @JsonProperty(value = VALUE)
    private String value;

    @JsonProperty(value = DESCRIPTION)
    private String description;

    @JsonProperty(value = TRANSACTION_DATE)
    private String transactionDate;

    @JsonProperty(value = EXPENSE)
    private ExpenseResponseModel expense;
}
