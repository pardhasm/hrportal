package com.hrportal.exception;

public class InputValidationException extends RuntimeException {
    private String exception;

    public InputValidationException(String exception) {
        super(exception);
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "InputValidationFailure { " +
                "messages=" + exception +
                '}';
    }
}
