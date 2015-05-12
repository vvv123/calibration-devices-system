package com.softserve.edu.documentGenerator.converter;

import java.io.File;

/**
 * Base interface for all converters to implement
 */
public interface Converter {
    /**
     * Convert the template file and save it in the specified path
     * @param readyTemplate document to convert
     * @param outputFileName path where to create converted file
     * @return converted file
     */
    File getConvertedFile(File readyTemplate, String outputFileName);
}
