package com.hrportal.exception;

import java.util.ArrayList;
import java.util.List;


public class ValidationException extends RuntimeException {

    private List<ValidationError> errors;

    public ValidationException(List<ValidationError> errors) {
        this.errors = errors;
    }

    public ValidationException(ValidationError error) {
        this.errors = new ArrayList<>(1);
        this.errors.add(error);
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
