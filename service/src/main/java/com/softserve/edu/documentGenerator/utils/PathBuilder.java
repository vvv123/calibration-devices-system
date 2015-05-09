package com.softserve.edu.documentGenerator.utils;

/**
 * Created by oleg on 5/9/15.
 */
public class PathBuilder {

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

    public static String build(StandardPath path, Template template) {
        return path.toString() + Delims.FOLDER_DELIMITER + template;
    }

    public static String build(StandardPath path, String fileName, DocumentFormat documentFormat) {
        return path.toString() + Delims.FOLDER_DELIMITER + fileName + Delims.DOT + documentFormat;
    }

}
