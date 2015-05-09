package com.softserve.edu.documentGenerator.utils;

/**
 * Created by oleg on 5/9/15.
 */
public enum StandardPaths {
    DOCUMENTS_TEMPLATES("documentsTemplates"),
    DOCUMENTS("documents"),
    FONTS("documentsTemplates");

    String path;

    StandardPaths(String path) {
        this.path = path;
    }
}
