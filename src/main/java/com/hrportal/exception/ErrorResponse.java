package com.hrportal.exception;


import java.util.List;

public class ErrorResponse {

    private List<ValidationError> errors;
    private String message;

    public ErrorResponse(List<ValidationError> errors) {
        this.errors = errors;
    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(List<ValidationError> errors, String message) {
        this.errors = errors;
        this.message = message;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public String getMessage() {
        return message;
    }
}