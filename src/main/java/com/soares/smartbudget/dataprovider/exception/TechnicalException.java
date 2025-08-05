package com.soares.smartbudget.dataprovider.exception;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;

import java.io.Serial;

public class TechnicalException extends ValidationException {

    @Serial
    private static final long serialVersionUID = -2469944587823949860L;

    public TechnicalException(ValidationResult validationResult) {
        super(validationResult);
    }
}
