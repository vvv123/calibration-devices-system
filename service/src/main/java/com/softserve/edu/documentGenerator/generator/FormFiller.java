package com.softserve.edu.documentGenerator.generator;

import com.softserve.edu.documentGenerator.generator.documents.Document;
import com.softserve.edu.documentGenerator.generator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.generator.documentWriter.VerificationCertificateWriter;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.PathBuilder;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FormFiller {
    private FormFiller() {
    }

    public static File getReadyTemplate(File template, Document document) {
        if (!(document instanceof VerificationCertificate)) {
            // TODO: throw custom exception
        }

        String path = PathBuilder.build(StandardPath.DOCUMENTS_GENERATED,
                String.valueOf(document.getVerificationID()),
                DocumentFormat.DOC);

        PrintWriter writer = null;
        File file = null;

        try {
            writer = new PrintWriter(path);
            file = new File(path);
            FileUtils.copyFile(template, file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

        VerificationCertificateWriter docWriter = new VerificationCertificateWriter(
                (VerificationCertificate)document, file);
        docWriter.write();

        return file;
    }
}
