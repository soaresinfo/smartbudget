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
public class InvestmentTypeResponseModel {

    public static final String ID_INVESTMENT_TYPE = "id_investment_type";
    public static final String DESCRIPTION = "description";

    @JsonProperty(value = ID_INVESTMENT_TYPE)
    private String idInvestmentType;

    @JsonProperty(value = DESCRIPTION)
    private String description;
}