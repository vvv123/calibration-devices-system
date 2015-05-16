package com.softserve.edu.document.generator;

import com.softserve.edu.document.generator.converter.Converter;
import com.softserve.edu.document.generator.converter.ConverterFactory;
import com.softserve.edu.document.generator.converter.DocumentFormat;
import com.softserve.edu.document.generator.documents.BaseDocument;
import com.softserve.edu.document.generator.utils.StandardPath;
import com.softserve.edu.document.generator.writer.DocxCreator;
import com.softserve.edu.document.generator.utils.PathBuilder;

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
        String documentName = "";
               // baseDocument.getDeviceName() + String.valueOf(baseDocument.getSerialNumber());

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
