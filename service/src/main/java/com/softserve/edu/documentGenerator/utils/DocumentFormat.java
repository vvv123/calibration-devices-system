package com.softserve.edu.documentGenerator.utils;

/**
 * Supported formats for documents generation
 */
public enum DocumentFormat {
    PDF, DOCX;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
