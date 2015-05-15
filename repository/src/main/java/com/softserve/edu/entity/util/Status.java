package com.softserve.edu.entity.util;

public enum Status {
    SENT("application sent"), RECEIVED("application received"), IN_PROGRESS("application in progress"), COMPLETED("application completed"),
    NOT_FOUND("application not found");

    private String name;

    private Status(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
