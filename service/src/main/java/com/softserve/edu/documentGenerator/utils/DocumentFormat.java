package com.softserve.edu.documentGenerator.utils;

/**
 * Created by oleg on 5/9/15.
 */
public enum DocumentFormat {
    PDF, DOC;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
