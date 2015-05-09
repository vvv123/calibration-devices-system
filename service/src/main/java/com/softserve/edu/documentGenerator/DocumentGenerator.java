package com.softserve.edu.documentGenerator;

import com.softserve.edu.documentGenerator.converter.Converter;
import com.softserve.edu.documentGenerator.converter.Converters;
import com.softserve.edu.documentGenerator.generator.FormFiller;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.PathBuilder;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import com.softserve.edu.documentGenerator.utils.Template;


import java.io.File;

/**
 * Created by oleg on 5/9/15.
 */
public class DocumentGenerator {
    static public File generate(Template templateFile, int verificationID, DocumentFormat documentFormat) {
        File template = templateFile.getFile();
        String outputFileName = PathBuilder.build(StandardPath.DOCUMENTS_GENERATED, String.valueOf(verificationID),
                documentFormat);

        File readyTemplate = FormFiller.getReadyTemplate(template, verificationID, outputFileName);

        Converter converter = Converters.get(documentFormat);
        File result = converter.getConvertedFile(readyTemplate);

        return result;
    }
}
