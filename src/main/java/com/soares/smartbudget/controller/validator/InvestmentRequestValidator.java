package com.soares.smartbudget.controller.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.StringPredicate;
import com.soares.smartbudget.controller.model.InvestmentRequestModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;

import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static com.soares.smartbudget.controller.model.InvestmentRequestModel.*;
import static java.util.function.Predicate.not;

@Component
public class InvestmentRequestValidator extends AbstractValidator<InvestmentRequestModel> {

    public static final String MSG_NULO_OU_VAZIO = "O campo '%s' não pode ser nulo ou vazio";
    public static final String MSG_NUMERIC = "O campo '%s' precisa ser numérico";
    public static final String MSG_DATE_FORMAT = "O campo '%s' precisa estar no formato 'yyyy-MM-dd'";
    public static final String MSG_ID_FORMAT = "O campo '%s' precisa ser um ID válido";

    @Override
    public void rules() {
        // Validação para ID_INVESTMENT (apenas se presente, para atualizações)
        ruleFor(InvestmentRequestModel::getIdInvestment)
                .must(id -> StringPredicate.isNumber().test(id))
                .when(not(stringEmptyOrNull()))
                .withAttempedValue(InvestmentRequestModel::getIdInvestment)
                .withFieldName(ID_INVESTMENT)
                .withMessage(String.format(MSG_ID_FORMAT, ID_INVESTMENT));

        // Validação para ID_INVESTMENT_TYPE
        ruleFor(InvestmentRequestModel::getIdInvestmentType)
                .must(not(stringEmptyOrNull()))
                .withFieldName(ID_INVESTMENT_TYPE)
                .withMessage(String.format(MSG_NULO_OU_VAZIO, ID_INVESTMENT_TYPE))
                .must(id -> StringPredicate.isNumber().test(id))
                .withFieldName(ID_INVESTMENT_TYPE)
                .withMessage(String.format(MSG_ID_FORMAT, ID_INVESTMENT_TYPE));

        // Validação para ID_LOCATION
        ruleFor(InvestmentRequestModel::getIdLocation)
                .must(not(stringEmptyOrNull()))
                .withFieldName(ID_LOCATION)
                .withMessage(String.format(MSG_NULO_OU_VAZIO, ID_LOCATION))
                .must(id -> StringPredicate.isNumber().test(id))
                .withFieldName(ID_LOCATION)
                .withMessage(String.format(MSG_ID_FORMAT, ID_LOCATION));

        // Validação para BALANCE
        ruleFor(InvestmentRequestModel::getBalance)
                .must(not(stringEmptyOrNull()))
                .withFieldName(BALANCE)
                .withMessage(String.format(MSG_NULO_OU_VAZIO, BALANCE))
                // CORREÇÃO: Usando uma expressão lambda para chamar o método isNumber
                .must(balance -> StringPredicate.isNumber().test(balance))
                .withFieldName(BALANCE)
                .withMessage(String.format(MSG_NUMERIC, BALANCE));

        // Validação para MONTH_REVENUE
        ruleFor(InvestmentRequestModel::getMonthRevenue)
                .must(not(stringEmptyOrNull()))
                .withFieldName(MONTH_REVENUE)
                .withMessage(String.format(MSG_NULO_OU_VAZIO, MONTH_REVENUE))
                // CORREÇÃO: Usando uma expressão lambda para chamar o método isNumber
                .must(revenue -> StringPredicate.isNumber().test(revenue))
                .withFieldName(MONTH_REVENUE)
                .withMessage(String.format(MSG_NUMERIC, MONTH_REVENUE));

        // Validação para LAST_UPDATE_DATE
        ruleFor(InvestmentRequestModel::getLastUpdateDate)
                .must(not(stringEmptyOrNull()))
                .withFieldName(LAST_UPDATE_DATE)
                .withMessage(String.format(MSG_NULO_OU_VAZIO, LAST_UPDATE_DATE))
                .must(this::isValidDateFormat)
                .withFieldName(LAST_UPDATE_DATE)
                .withMessage(String.format(MSG_DATE_FORMAT, LAST_UPDATE_DATE));
    }

    /**
     * Helper method to validate if a string is a valid date in 'yyyy-MM-dd' format.
     * @param dateString The string to validate.
     * @return true if the string is a valid date, false otherwise.
     */
    private boolean isValidDateFormat(String dateString) {
        if (dateString == null) return false;
        try {
            LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Helper method to validate if a string is a valid UUID.
     * @param uuidString The string to validate.
     * @return true if the string is a valid UUID, false otherwise.
     */
    private boolean isValidUUID(String uuidString) {
        if (uuidString == null) return false;
        try {
            UUID.fromString(uuidString);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}