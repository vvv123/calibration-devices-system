package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.converter.DocumentFormat;
import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import com.softserve.edu.documentGenerator.utils.PathBuilder;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
