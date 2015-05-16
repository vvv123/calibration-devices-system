package com.softserve.edu.entity.util;

public enum Status {
    SENT("application sent"), RECEIVED("application received"), IN_PROGRESS("application in progress"),
    COMPLETED("application completed"), NOT_FOUND("application not found");

    private String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return statusName;
    }
}
