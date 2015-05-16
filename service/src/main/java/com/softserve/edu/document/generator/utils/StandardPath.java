package com.softserve.edu.document.generator.utils;

/**
 * Constants for standard paths
 */
public enum StandardPath {
    DOCUMENTS_TEMPLATES {
        @Override
        public String toString() {
            return "documentsTemplates";
        }
    },
    DOCUMENTS_GENERATED {
        @Override
        public String toString() {
            return "documents";
        }
    },
    FONTS {
        @Override
        public String toString() {
            return "fonts";
        }
    }
}
