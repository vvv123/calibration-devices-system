package com.softserve.edu.documentGenerator.utils;

/**
 * Supported formats for documents generation
 */
public enum DocumentFormat {
    PDF, DOC;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
