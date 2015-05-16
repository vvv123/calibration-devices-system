package com.softserve.edu.documentGenerator;

import com.softserve.edu.documentGenerator.converter.Converter;
import com.softserve.edu.documentGenerator.converter.ConverterFactory;
import com.softserve.edu.documentGenerator.converter.DocumentFormat;
import com.softserve.edu.documentGenerator.documentWriter.DocxCreator;
import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.utils.PathBuilder;
import com.softserve.edu.documentGenerator.utils.StandardPath;

import java.io.File;
import java.io.IOException;

public class DocumentGenerator {

    /**
     * Generates file of the specified format, using the baseDocument as the source.
     *
     * @param baseDocument   baseDocument to generate file from
     * @param documentFormat format of the generated file
     * @return resulting file
     */
    static public File generate(BaseDocument baseDocument, DocumentFormat documentFormat) {
        String documentName =  baseDocument.getDeviceName() +
                String.valueOf(baseDocument.getDeviceManufacturerSerial());

        String outputFileName = PathBuilder.build(StandardPath.DOCUMENTS_GENERATED,
                documentName,
                documentFormat);

        File docxDocument = null;

        try {
            docxDocument = DocxCreator.createDocxDocument(baseDocument);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }

        File convertedFile = new File(outputFileName);
        Converter converter = ConverterFactory.get(documentFormat);

        try {
            converter.convertFile(docxDocument, convertedFile);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }

        return convertedFile;
    }

}
