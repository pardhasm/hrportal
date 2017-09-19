package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum FrequencyPay {
    HOURLY("Hourly"),DAILY("Daily"),BIWEEKLY("Bi Weekly"),WEEKLY("Weekly"),SEMI_MONTHLY("Semi Monthly"),MONTHLY("Monthly");

    private String frequency;

    FrequencyPay(String frequency) {
        this.frequency = frequency;
    }
}
