package com.softserve.edu.documentGenerator.converter;

import com.softserve.edu.documentGenerator.utils.DocumentFormat;

public class Converters {
    /**
     * Get the correct converter for the specified file format
     * @param documentFormat format to get converter for
     * @return
     */
    public static Converter get(DocumentFormat documentFormat) {
        return new DocToPdf();
    }
}
