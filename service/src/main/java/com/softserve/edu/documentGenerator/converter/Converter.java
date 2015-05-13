package com.softserve.edu.documentGenerator.converter;

import java.io.File;
import java.io.IOException;

/**
 * Base interface for all converters to implement
 */
public interface Converter {
    /**
     * Converts the template file and save it in the specified path
     * @param sourceFile document to convert
     * @param outputFile document to store converted data
     * @throws IOException in case of inability to use files
     */
    void convertFile(File sourceFile, File outputFile) throws IOException;
}
