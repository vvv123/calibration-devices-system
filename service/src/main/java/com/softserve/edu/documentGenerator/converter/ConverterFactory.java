package com.softserve.edu.documentGenerator.converter;

import static com.softserve.edu.documentGenerator.converter.DocumentFormat.*;

public class ConverterFactory {
    /**
     * Get the correct converter for the specified file format
     * @param documentFormat format to get converter for
     */
    public static Converter get(DocumentFormat documentFormat) {
        Converter converter = null;

           switch (documentFormat) {
               case PDF:
                   converter = new DocToPdf2();
                   break;
           }

        return converter;
    }
}
