package com.softserve.edu.documentGenerator;

import com.softserve.edu.documentGenerator.converter.Converter;
import com.softserve.edu.documentGenerator.converter.Converters;
import com.softserve.edu.documentGenerator.documentWriter.TemplateFiller;
import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.PathBuilder;
import com.softserve.edu.documentGenerator.utils.StandardPath;

import java.io.File;

public class DocumentGenerator {

    /**
     * Generate file of the specified format, using the baseDocument as the source.
     * @param baseDocument baseDocument to generate file from
     * @param documentFormat format of the generated file
     * @return resulting file
     */
    static public File generate(BaseDocument baseDocument, DocumentFormat documentFormat) {
        File template = baseDocument.getTemplate().getFile();
        String outputFileName = PathBuilder.build(StandardPath.DOCUMENTS_GENERATED,
                String.valueOf(baseDocument.getVerificationID()),
                documentFormat);

        File readyTemplate = TemplateFiller.getReadyTemplate(template, baseDocument);

        Converter converter = Converters.get(documentFormat);
        File result = converter.getConvertedFile(readyTemplate, outputFileName);

        return result;
    }

}
