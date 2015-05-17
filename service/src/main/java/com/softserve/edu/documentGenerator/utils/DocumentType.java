package com.softserve.edu.documentGenerator.utils;

import java.io.File;

/**
 * Types of documents supported by the application.
 */
public enum DocumentType {
    VERIFICATION_CERTIFICATE,
    UNFITNESS_CERTIFICATE;

    /**
     * @return the template's name with format
     */
    @Override
    public String toString() {
        return name().toLowerCase() + ".docx";
    }

    /**
     * @return the template's file.
     */
    public File getTemplate() {
        String path = PathBuilder.build(StandardPath.DOCUMENTS_TEMPLATES, this);
        return new File(path);
    }

}