package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;

/**
 * Class for writing verification certificate into a template file
 * Writer for unfitness certificate.
 */
public class VerificationCertificateWriter {
    private VerificationCertificate document;
    private File file;

    enum Token {
        AD_PAGE,
        SPEC_DOC_ID,
        SPEC_DOC_NAME;

        @Override
        public String toString() {
            return "$" + name();
        }
    }

    public VerificationCertificateWriter(VerificationCertificate document, File file) {
        this.document = document;
        this.file = file;
    }

    public void write() throws IOException, InvalidFormatException {
        DocumentWriter documentWriter = new DocumentWriter(document);
        documentWriter.write(file);

        TokenWriter tokenWriter = new TokenWriter();

        Integer additionalInfoPageNumber = document.getAdditionalInfoPageNumber();
        tokenWriter.replaceToken(file, Token.AD_PAGE.toString(),
                additionalInfoPageNumber.toString());

        String documentId = document.getDocumentId();
        tokenWriter.replaceToken(file, Token.SPEC_DOC_ID.toString(),
                documentId);

        String specificationDocumentName = document.getSpecificationDocumentName();
        tokenWriter.replaceToken(file, Token.SPEC_DOC_NAME.toString(),
                specificationDocumentName);
    }
}
