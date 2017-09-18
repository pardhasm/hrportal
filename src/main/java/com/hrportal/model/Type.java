package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum Type {
    COMPANY("Company"), HEADOFFICE("Head Office"), REGIONALOFFICE("Regional Office"), DEPARTMENT("Department"), UNIT("Unit"), SUBUNIT("Sub Unit"), OTHER("Other");

    private String type;

    Type(String type) {
        this.type = type;
    }
}
