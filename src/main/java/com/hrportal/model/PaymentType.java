package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum PaymentType {
    COMPANY_SPONSORED("Company Sponsored"),PAID_BY_EMPLOYEE("Paid By Employee");

    private String paymentType;

    PaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
