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
public class ExpenseResponseModel {

    private static final String ID_EXPENSE = "id_expense";
    private static final String PLANNED_VALUE = "planned_value";
    private static final String DESCRIPTION = "description";

    @JsonProperty(value = ID_EXPENSE)
    private String idExpense;

    @JsonProperty(value = PLANNED_VALUE)
    private String plannedValue;

    @JsonProperty(value = DESCRIPTION)
    private String description;
}
