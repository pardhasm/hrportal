package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum MaritalStatus {
    MARRIED("Married"),SINGLE("Single"),DIVORCED("Divorced"),WIDOWED("Widowed"),OTHER("Other");

    private String maritalStatus;

    MaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
