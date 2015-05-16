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
    enum VerificationCertificateToken implements Token {
        EFF_DATE,
        METR_DOC_SIGN,
        METR_DOC_NAME;

        @Override
        public String getTokenName() {
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

        tokenWriter.replaceToken(VerificationCertificateToken.METR_DOC_NAME.getTokenName(),
                document.getMetrologicalDocumentName());

        tokenWriter.replaceToken(VerificationCertificateToken.METR_DOC_SIGN.getTokenName(),
                document.getMetrologicalDocumentSign());

        tokenWriter.replaceToken(VerificationCertificateToken.EFF_DATE.getTokenName(),
                document.getVerificationCertificateEffectiveUntilDate());
    }
}
