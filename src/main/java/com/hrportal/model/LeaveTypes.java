package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum LeaveTypes {
    FULLDAY("Full Day"),HALDAYMORNING("Half Day - Morning"),HALFDAYAFTERNOON("Half Day - Afternoon"),HOUR1MORNING("1 - Hour Morning"),HOURS2MORNING("2 - Hours Morning"),HOURS3MORNING("3 - Hours Morning"),HOUR1AFTERNOON("1 - Hour Afternoon"),HOURS3AFTERNOON("3 - Hours Afternoon");

    private String leave;

    LeaveTypes(String leave) {
        this.leave = leave;
    }
}
