package com.softserve.edu.documentGenerator.utils;

import java.io.File;

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
        String pathToReource = path.toString() + Delims.FOLDER_DELIMITER + documentType;
        PathBuilder pathBuilder = new PathBuilder();
        return pathBuilder.getResource(pathToReource);
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
        String pathToReource =  path.toString() + Delims.FOLDER_DELIMITER + fileName + Delims.DOT + documentFormat;
        PathBuilder pathBuilder = new PathBuilder();
        return pathBuilder.getResource(pathToReource);
    }

    private String getResource(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        return file.getAbsolutePath();
    }

}
