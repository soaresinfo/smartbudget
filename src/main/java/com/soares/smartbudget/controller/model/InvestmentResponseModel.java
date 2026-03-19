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
    public static final String ID_PORTFOLIO = "id_portfolio";
    public static final String INVESTMENT_TYPE = "investment_type";
    public static final String BALANCE = "balance";
    public static final String MONTH_REVENUE = "month_revenue";
    public static final String LOCATION = "location";
    public static final String LAST_UPDATE_DATE = "last_update_date";
    public static final String CONTRIBUTION = "contribution";
    public static final String WITHDRAW = "withdraw";

    @JsonProperty(value = ID_INVESTMENT)
    private String idInvestment;

    @JsonProperty(value = ID_PORTFOLIO)
    private String idPortfolio;

    @JsonProperty(value = INVESTMENT_TYPE)
    private InvestmentTypeResponseModel investmentType;

    @JsonProperty(value = LOCATION)
    private LocationResponseModel location;

    @JsonProperty(value = BALANCE)
    private String balance;

    @JsonProperty(value = MONTH_REVENUE)
    private String monthRevenue;

    @JsonProperty(value = CONTRIBUTION)
    private String contribution;

    @JsonProperty(value = WITHDRAW)
    private String withdraw;

    @JsonProperty(value = LAST_UPDATE_DATE)
    private String lastUpdateDate;
}