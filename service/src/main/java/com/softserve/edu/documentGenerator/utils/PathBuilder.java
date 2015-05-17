package com.softserve.edu.documentGenerator.utils;

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
     * @param path         standard path constant
     * @param documentType documentType file
     * @return path
     */
    public static String build(StandardPath path, DocumentType documentType) {
        return path.toString() + Delims.FOLDER_DELIMITER + documentType;
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
