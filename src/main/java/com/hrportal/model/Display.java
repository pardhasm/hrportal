package com.hrportal.model;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
public enum Display {
    FORM("Form"),TABLE_AND_FORM("Table and Form"),HIDDEN("Hidden");

    private String display;

    Display(String display) {
        this.display = display;
    }
}
