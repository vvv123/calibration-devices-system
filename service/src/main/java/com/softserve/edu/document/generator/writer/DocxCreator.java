package com.softserve.edu.document.generator.writer;

import com.softserve.edu.document.generator.converter.DocumentFormat;
import com.softserve.edu.document.generator.documents.BaseDocument;
import com.softserve.edu.document.generator.documents.VerificationCertificate;
import com.softserve.edu.document.generator.utils.DocumentUtils;
import com.softserve.edu.document.generator.utils.StandardPath;
import com.softserve.edu.document.generator.utils.PathBuilder;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class DocxCreator {

    /**
     * Private default constructor.
     */
    private DocxCreator() {
    }

    /**
     * Gets a copy of the baseDocument that has the correct data and is ready to be converted.
     *
     * @param baseDocument baseDocument with the data to be used for the file generation.
     * @return
     */
    public static File createDocxDocument(BaseDocument baseDocument) throws IOException {
        // create copy of the document's template
        String documentName = ""; // baseDocument.getDeviceName() + String.valueOf(baseDocument.getSerialNumber());
        String path = PathBuilder.build(StandardPath.DOCUMENTS_GENERATED,
                documentName,
                DocumentFormat.DOCX);
        File file = DocumentUtils.createCopy(baseDocument.getTemplate().getFile(), path);

        // write baseDocuments's data to template
        VerificationCertificateWriter docWriter = new VerificationCertificateWriter(
                (VerificationCertificate) baseDocument, file);

        try {
            docWriter.write();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new IOException("specified file is of invalid format");
        }

        return file;
    }
}
