package com.softserve.edu.documentGenerator.utils;

/**
 * Constants for standard paths
 */
public enum StandardPath {
    DOCUMENTS_TEMPLATES {
        @Override
        public String toString() {
            return "/home/oleg/mydocuments/documentsTemplates";
        }
    },
    DOCUMENTS_GENERATED {
        @Override
        public String toString() {
            return "/home/oleg/mydocuments/documents";
        }
    },
    FONTS {
        @Override
        public String toString() {
            return "/home/oleg/mydocuments/fonts";
        }
    }
}
