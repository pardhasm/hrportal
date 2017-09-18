package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum Status {
    ACTIVE("Active"), TERMINATED("Terminated");

    private String status;

    Status(String status) {
        this.status = status;
    }
}
