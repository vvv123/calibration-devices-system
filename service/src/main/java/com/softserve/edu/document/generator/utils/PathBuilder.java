package com.softserve.edu.document.generator.utils;

import com.softserve.edu.document.generator.converter.DocumentFormat;

/**
 * Path builder.
 */
public class PathBuilder {

    /**
     * Contains path delimiters
     */
    enum Delims {
        DOT("."),
        FOLDER_DELIMITER("/");

        private String val;

        Delims(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    /**
     * Build path.
     *
     * @param path     standard path constant
     * @param template template file
     * @return path
     */
    public static String build(StandardPath path, Template template) {
        return path.toString() + Delims.FOLDER_DELIMITER + template;
    }

    /**
     * Build path.
     *
     * @param path           standard path constant
     * @param fileName       name of the file without .format
     * @param documentFormat document's format
     * @return path
     */
    public static String build(StandardPath path, String fileName, DocumentFormat documentFormat) {
        return path.toString() + Delims.FOLDER_DELIMITER + fileName + Delims.DOT + documentFormat;
    }

}
