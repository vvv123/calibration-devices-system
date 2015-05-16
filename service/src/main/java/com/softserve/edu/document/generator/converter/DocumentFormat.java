package com.softserve.edu.document.generator.converter;

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
