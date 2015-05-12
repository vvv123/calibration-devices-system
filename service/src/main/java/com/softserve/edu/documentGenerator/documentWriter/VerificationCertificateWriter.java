package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.documents.documentsFields.VerificationCertificateData;

import java.io.File;

/**
 * Class for writing verification certificate into a template file
 * Writer for unfitness certificate.
 */
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

        TokenWriter tokenWriter = new TokenWriter();

        VerificationCertificateData verificationCertificateData = doc.getVerificationCertificateData();
        Integer additionalInfoPageNumber = verificationCertificateData.getAdditionalInfoPageNumber();
        tokenWriter.replaceTokenAndSave(file, "$AD_PAGE", additionalInfoPageNumber.toString());

        String documentId = verificationCertificateData.getDocumentId();
        tokenWriter.replaceTokenAndSave(file, "$SPEC_DOC_ID", documentId);

        String specificationDocumentName = verificationCertificateData.getSpecificationDocumentName();
        tokenWriter.replaceTokenAndSave(file, "$SPEC_DOC_NAME", specificationDocumentName);
    }
}
