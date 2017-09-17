package com.hrportal.model;

/**
 * Created by pardha on 9/17/17.
 */
public enum MaritalStatus {
    MARRIED("Married"), SINGLE("Single"), DIVORCED("Divorced"), WIDOWED("Widowed"), OTHER("Other");

    private String status;

    MaritalStatus(String status) {
        this.status = status;
    }
}
