package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum Type {
    COMPANY("Company"), HEADOFFICE("HeadOffice"), REGIONALOFFICE("RegionalOffice"), DEPARTMENT("Department"), UNIT("Unit"), SUBUNIT("SubUnit"), OTHER("Other");

    private String type;

    Type(String type) {
        this.type = type;
    }
}
