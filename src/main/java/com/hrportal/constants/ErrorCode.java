package com.hrportal.constants;

public enum ErrorCode {
    INPUT_VALIDATION_ERROR("INPUT_VALIDATION_ERROR"),
    APPLICATION_ERROR("APPLICATION_ERROR"),
    LOGIN_FAILED("LOGIN_FAILED"),
    AUTHORIZATION_FAILED("AUTHORIZATION_FAILED"),
    ENTITY_NOT_FOUND("ENTITY_NOT_FOUND"),
    UNSUPPORTED_DEVICE("UNSUPPORTED_DEVICE"),
    DUPLICATE_ENTITY_EXCEPTION("DUPLICATE ENTITY"),
    ACCESS_DENIED_EXCEPTION("ACCESS DENIED"),
    DB_UNAVAILABLE("DB UNAVAILABLE");

    String value;

    ErrorCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

