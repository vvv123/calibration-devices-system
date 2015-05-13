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
    private VerificationCertificate doc;
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

    public VerificationCertificateWriter(VerificationCertificate doc, File file) {
        this.doc = doc;
        this.file = file;
    }

    public void write() throws IOException, InvalidFormatException {
        DocumentWriter documentWriter = new DocumentWriter(doc);
        documentWriter.write(file);

        TokenWriter tokenWriter = new TokenWriter();

        Integer additionalInfoPageNumber = doc.getAdditionalInfoPageNumber();
        tokenWriter.replaceToken(file, Token.AD_PAGE.toString(),
                additionalInfoPageNumber.toString());

        String documentId = doc.getDocumentId();
        tokenWriter.replaceToken(file, Token.SPEC_DOC_ID.toString(),
                documentId);

        String specificationDocumentName = doc.getSpecificationDocumentName();
        tokenWriter.replaceToken(file, Token.SPEC_DOC_NAME.toString(),
                specificationDocumentName);
    }
}
