package com.hrportal.util;

/**
 * Created by pardha on 9/23/17.
 */
public class FieldErrorDTO {

    private String field;

    private String message;

    public FieldErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    //Getters are omitted.
}
