package com.softserve.edu.documentGenerator.generator.documentWriter;

import com.softserve.edu.documentGenerator.generator.documents.VerificationCertificate;

import java.io.File;

public class VerificationCertificateWriter {
    private VerificationCertificate doc;
    private File file;

    public VerificationCertificateWriter(VerificationCertificate doc, File file) {
        this.doc = doc;
        this.file = file;
    }

    public void write() {
        DocumentWriter documentWriter = new DocumentWriter(doc);
        documentWriter.write(file);

        Writer writer = new Writer();
    }
}
