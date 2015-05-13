package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;

/**
 * Class for writing verification certificate into a file
 */
public class VerificationCertificateWriter extends DocumentWriter {
    private VerificationCertificate document;
    private File file;

    /**
     * Consists of names of tokens from file;
     */
    enum Token {
        AD_PAGE,
        SPEC_DOC_ID,
        SPEC_DOC_NAME;

        @Override
        public String toString() {
            return "$" + name();
        }
    }

    /**
     * Constructor
     * @param document document to write
     * @param file for writing document
     */
    public VerificationCertificateWriter(VerificationCertificate document, File file) {
        super(document, file);
        this.document = document;
        this.file = file;
    }

    /**
     * Write document into the file
     * @throws IOException
     * @throws InvalidFormatException
     */
    public void write() throws IOException, InvalidFormatException {
        //DocumentWriter documentWriter = new DocumentWriter(document, file);
        super.write();
        //documentWriter.write();

        TokenWriter tokenWriter = new TokenWriter(file);

        Integer additionalInfoPageNumber = document.getAdditionalInfoPageNumber();
        tokenWriter.replaceToken(Token.AD_PAGE.toString(),
                additionalInfoPageNumber.toString());

        String documentId = document.getDocumentId();
        tokenWriter.replaceToken(Token.SPEC_DOC_ID.toString(),
                documentId);

        String specificationDocumentName = document.getSpecificationDocumentName();
        tokenWriter.replaceToken(Token.SPEC_DOC_NAME.toString(),
                specificationDocumentName);
    }
}
