package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum DeliveryMethod {
    CLASSROOM("Classroom"),SELFSTUDY("Self Study"),ONLINE("Online");


    private String deliveryMethod;

    DeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
