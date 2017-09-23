package com.hrportal.exception;

public class ErrorDto {
    private String code;
    private String message;
    private String internalMessage;

    public ErrorDto(com.hrportal.constants.ErrorCode code, String message) {
        this.code = code.getValue();
        this.message = message;
    }

    public ErrorDto(String code, String message, String internalMessage) {
        this.code = code;
        this.message = message;
        this.internalMessage = internalMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInternalMessage() {
        return internalMessage;
    }

    public void setInternalMessage(String internalMessage) {
        this.internalMessage = internalMessage;
    }
}
