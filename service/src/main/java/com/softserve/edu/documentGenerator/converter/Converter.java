package com.softserve.edu.documentGenerator.converter;

import java.io.File;

/**
 * Base interface for all converters to implement
 */
public interface Converter {
    /**
     * Convert the template file and save it in the specified path
     * @param readyTemplate document to convert
     * @param outputFileName document to store converted data
     */
    void convertFile(File readyTemplate, File outputFileName);
}
