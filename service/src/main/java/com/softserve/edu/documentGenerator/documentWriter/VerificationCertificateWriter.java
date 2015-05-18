package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.VerificationCertificate;

/**
 * Class for writing verification certificate into a file
 */
public class VerificationCertificateWriter extends DocumentWriter<VerificationCertificate> {
    @Override
    public String replaceTokens(String text) {
        text = super.replaceTokens(text);

        text = text.replace(VerificationCertificateToken.METR_DOC_NAME.getTokenName(),
                getDocument().getMetrologicalDocumentName());

        text = text.replace(VerificationCertificateToken.METR_DOC_SIGN.getTokenName(),
                getDocument().getMetrologicalDocumentSign());

        text = text.replace(VerificationCertificateToken.EFF_DATE.getTokenName(),
                getDocument().getVerificationCertificateEffectiveUntilDate());

        return text;
    }

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
     *
     * @param document document to write
     */
    public VerificationCertificateWriter(VerificationCertificate document) {
        super(document);
    }
}
