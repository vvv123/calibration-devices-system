package com.softserve.edu.entity.util;

public enum Status {
    SENT("Application sent."), RECEIVED("Application received."), IN_PROGRESS("Application in progress."),
    COMPLETED("Application completed."), NOT_FOUND("Application not found.");

    private String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return statusName;
    }
}
