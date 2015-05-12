package com.softserve.edu.documentGenerator.utils;

import java.io.File;

/**
 * Templates of documents supported by the application.
 */
public enum Template {
    VERIFICATION_CERTIFICATE,
    UNFITNESS_CERTIFICATE,
    VERIFICATION_PROTOCOL;

    /**
     * @return the template's name with format
     */
    @Override
    public String toString() {
        return name().toLowerCase() + ".doc";
    }

    /**
     * @return the template's file.
     */
    public File getFile() {
        String path = PathBuilder.build(StandardPath.DOCUMENTS_TEMPLATES, this);
        DocumentUtils utils = new DocumentUtils();
        return new File(utils.getFilePath(path));
    }
}
