package com.soares.smartbudget.controller.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.LogicalPredicate;
import br.com.fluentvalidator.predicate.StringPredicate;

import java.util.Objects;
import java.util.function.Function;

import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static java.util.function.Function.identity;
import static java.util.function.Predicate.not;

public class DateValidator extends AbstractValidator<String> {

    public static final String MSG_NULO_OU_VAZIO = "O campo '%s' não pode ser nulo ou vazio";
    public static final String MSG_DATE_FORMAT = "Campo '%s' deve estar no formato de data yyyy-MM-dd.";

    private final Function<Object, String> composeFieldName;

    private DateValidator(final Function<Object, String> composeFieldName) {
        this.composeFieldName = Objects.requireNonNull(composeFieldName, "Function must not be null");
    }

    public DateValidator(final String fieldName) {

        this(fn -> fieldName);
    }

    @Override
    public void rules() {
        ruleFor(identity())
                .must(not(stringEmptyOrNull()))
                .withMessage(fn -> String.format(MSG_NULO_OU_VAZIO, composeFieldName.apply(fn)))
                .withFieldName(composeFieldName::apply)
                .withAttempedValue(value -> value)

                .must(StringPredicate.stringMatches("^\\d{4}-\\d{2}-\\d{2}$")).when(LogicalPredicate.not(stringEmptyOrNull()))
                .withMessage(fn -> String.format(MSG_DATE_FORMAT, composeFieldName.apply(fn)))
                .withFieldName(composeFieldName::apply)
                .withAttempedValue(value -> value);
    }
}
