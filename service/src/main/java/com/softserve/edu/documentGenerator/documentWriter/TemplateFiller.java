package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.converter.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.PathBuilder;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import com.softserve.edu.documentGenerator.utils.Template;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TemplateFiller {

    /**
     * private default constructor
     */
    private TemplateFiller() { }

    /**
     * Get copy of the baseDocument that has the correct data and is ready to be converted.
     * @param baseDocument baseDocument with the data to be used for the file generation
     * @return
     */
    public static File getReadyTemplate(BaseDocument baseDocument) {
        if (!(baseDocument instanceof VerificationCertificate)) {
            // TODO: throw custom exception
        }

        String path = PathBuilder.build(StandardPath.DOCUMENTS_GENERATED,
                String.valueOf(baseDocument.getSerialNumber()),
                DocumentFormat.DOCX);

        PrintWriter writer = null;
        File file = null;

        try {
            writer = new PrintWriter(path);
            file = new File(path);
            Template template = baseDocument.getTemplate();
            File file1 = template.getFile();
            FileUtils.copyFile(file1, file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

        VerificationCertificateWriter docWriter = new VerificationCertificateWriter(
                (VerificationCertificate) baseDocument, file);
        docWriter.write();

        return file;
    }
}
