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
public class InvestmentResponseModel {

    public static final String ID_INVESTMENT = "id_investment";
    public static final String INVESTMENT_TYPE = "investment_type";
    public static final String BALANCE = "balance";
    public static final String MONTH_REVENUE = "month_revenue";
    public static final String LOCATION = "location";
    public static final String LAST_UPDATE_DATE = "last_update_date";

    @JsonProperty(value = ID_INVESTMENT)
    private String idInvestment;

    @JsonProperty(value = INVESTMENT_TYPE)
    private InvestmentTypeResponseModel investmentType;

    @JsonProperty(value = LOCATION)
    private LocationResponseModel location;

    @JsonProperty(value = BALANCE)
    private String balance;

    @JsonProperty(value = MONTH_REVENUE)
    private String monthRevenue;

    @JsonProperty(value = LAST_UPDATE_DATE)
    private String lastUpdateDate;
}