package com.softserve.edu.documentGenerator;

import java.io.File;

/**
 * Utility methods for documents
 */
public class Utils {
    /**
     * Get file's path from resources folder
     */
    public String getFilePath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        return file.getAbsolutePath();
    }
}
