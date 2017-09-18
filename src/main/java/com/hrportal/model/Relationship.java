package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum Relationship {
    CHILD("Child"),SPOUSE("Spouse"),PARENT("Parent"),OTHER("Other");

    private String relationship;

    Relationship(String relationship) {
        this.relationship = relationship;
    }
}
