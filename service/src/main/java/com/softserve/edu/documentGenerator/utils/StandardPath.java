package com.softserve.edu.documentGenerator.utils;

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
    };

//    private String path;
//
////    StandardPath(String path) {
////        this.path = path;
////    }
//
//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }
}
