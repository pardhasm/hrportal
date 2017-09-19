package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum Approval {
    APPROVED("Approved"),PENDING("Pending"),REJECTED("Rejected"),CANCELLATION_REQUEST("Cancellation Request"),CANCELLED("Cancelled"),PROCESSING("Processing");

    private String approval;

    Approval(String approval) {
        this.approval = approval;
    }
}
