package com.soares.smartbudget.controller.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.StringPredicate;
import com.soares.smartbudget.controller.model.TransactionRequestModel;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static com.soares.smartbudget.controller.model.TransactionRequestModel.TRANSACTION_DATE;
import static com.soares.smartbudget.controller.model.TransactionRequestModel.VALUE;
import static java.util.function.Predicate.not;

@Component
public class TransactionRequestValidator extends AbstractValidator<TransactionRequestModel> {

    public static final String MSG_NULO_OU_VAZIO = "O campo '%s' não pode ser nulo ou vazio";
    public static final String MSG_NUMERIC = "O campo '%s' precisa ser numérico";

    @Override
    public void rules() {
        ruleFor(request -> request)
                .must(not(stringEmptyOrNull(TransactionRequestModel::getValue)))
                .withAttempedValue(TransactionRequestModel::getValue)
                .withFieldName(VALUE)
                .withMessage(String.format(MSG_NULO_OU_VAZIO, VALUE))

                .must(StringPredicate.isNumber(TransactionRequestModel::getValue))
                .withAttempedValue(TransactionRequestModel::getValue)
                .withFieldName(VALUE)
                .withMessage(MSG_NUMERIC)

                .must(not(stringEmptyOrNull(TransactionRequestModel::getTransactionDate)))
                .withAttempedValue(TransactionRequestModel::getTransactionDate)
                .withFieldName(TransactionRequestModel.TRANSACTION_DATE)
                .withMessage(String.format(MSG_NULO_OU_VAZIO, TRANSACTION_DATE))
                ;
    }
}
