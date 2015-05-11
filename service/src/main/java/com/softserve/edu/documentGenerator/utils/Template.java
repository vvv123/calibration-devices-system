package com.softserve.edu.documentGenerator.utils;

import java.io.File;

/**
 * Created by oleg on 5/9/15.
 */
public enum Template {
    VERIFICATION_CERTIFICATE,
    UNFITNESS_CERTIFICATE,
    VERIFICATION_PROTOCOL;

    @Override
    public String toString() {
        String templateName = name().toLowerCase() + ".doc";
        return templateName;
    }

    public File getFile() {
        String path = PathBuilder.build(StandardPath.DOCUMENTS_TEMPLATES, this);
        DocumentUtils utils = new DocumentUtils();
        return new File(utils.getFilePath(path));
    }
}
