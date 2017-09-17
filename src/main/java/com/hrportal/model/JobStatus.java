package com.hrportal.model;

/**
 * Created by pardha on 9/17/17.
 */
public enum JobStatus {

    ACTIVE("Active"), ON_HOLD("On Hold"), CLOSED("Closed");

    private String status;

    JobStatus(String status) {
        this.status = status;
    }
}
