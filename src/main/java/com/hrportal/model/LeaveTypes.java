package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum LeaveTypes {
    FULL_DAY("Full Day"),HALF_DAY_MORNING("Half Day - Morning"),HALF_DAY_AFTERNOON("Half Day - Afternoon"),ONE_HOUR_MORNING("1 - Hour Morning"),TWO_HOUR_MORNING("2 - Hours Morning"),THREE_HOUR_MORNING("3 - Hours Morning"),ONE_HOUR_AFTERNOON("1 - Hour Afternoon"),TWO_HOUR_AFTERNOON("2 - Hour Afternoon"),THREE_HOUR_AFTERNOON("3 - Hours Afternoon");

    private String leave;

    LeaveTypes(String leave) {
        this.leave = leave;
    }
}
