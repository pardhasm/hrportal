package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum UserLevel {
    ADMIN("Admin"),EMPLOYEE("Employee"),MANAGER("Manager"),OTHER("Other");

    private String userLevel;

    UserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
}
