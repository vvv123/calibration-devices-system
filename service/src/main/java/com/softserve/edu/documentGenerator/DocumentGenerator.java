package com.softserve.edu.documentGenerator;

import com.softserve.edu.documentGenerator.converter.Converter;
import com.softserve.edu.documentGenerator.converter.Converters;
import com.softserve.edu.documentGenerator.generator.FormFiller;
import com.softserve.edu.documentGenerator.generator.documents.Document;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.PathBuilder;
import com.softserve.edu.documentGenerator.utils.StandardPath;

import java.io.File;

public class DocumentGenerator {
    static public File generate(Document document, DocumentFormat documentFormat) {
        File template = document.getTemplate().getFile();
        String outputFileName = PathBuilder.build(StandardPath.DOCUMENTS_GENERATED,
                String.valueOf(document.getVerificationID()),
                documentFormat);

        File readyTemplate = FormFiller.getReadyTemplate(template, document);

        Converter converter = Converters.get(documentFormat);
        File result = converter.getConvertedFile(readyTemplate, outputFileName);

        return result;
    }
}
