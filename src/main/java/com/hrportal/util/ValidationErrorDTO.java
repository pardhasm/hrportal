package com.hrportal.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pardha on 9/23/17.
 */
public class ValidationErrorDTO {

    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public ValidationErrorDTO() {

    }

    public void addFieldError(String path, String message) {
        FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldErrors.add(error);
    }

    //Getter is omitted.
}
