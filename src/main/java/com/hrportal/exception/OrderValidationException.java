package com.hrportal.exception;

/**
 * Created by saitejatokala on 27/05/16.
 */
public class OrderValidationException extends RuntimeException {

    private String code;

    public OrderValidationException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}