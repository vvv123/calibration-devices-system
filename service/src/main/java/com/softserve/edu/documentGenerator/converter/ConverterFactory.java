package com.softserve.edu.documentGenerator.converter;

public class ConverterFactory {
    /**
     * Returns the correct converter for the specified file format
     *
     * @param documentFormat format to get converter for
     */
    public static Converter get(DocumentFormat documentFormat) {
        Converter converter = null;

        switch (documentFormat) {
            case PDF:
                converter = new DocxToPdf();
                break;
        }

        return converter;
    }
}
