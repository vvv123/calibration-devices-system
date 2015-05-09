package com.softserve.edu.documentGenerator.utils;

/**
 * Created by oleg on 5/9/15.
 */
public enum DocumentFormat {
    PDF;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
