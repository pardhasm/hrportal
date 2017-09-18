package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum AttendanceType {
    SIGNUP("Sign Up"),ASSIGN("Assign");

    private String attendance;

    AttendanceType(String attendance) {
        this.attendance = attendance;
    }
}
