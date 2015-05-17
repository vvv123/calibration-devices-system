package com.softserve.edu.documentGenerator.Writer;

import com.softserve.edu.documentGenerator.documents.UnfitnessCertificate;

/**
 * Class for writing an unfitness certificate into a template file
 * Writer for unfitness certificate.
 */
public class UnfitnessCertificateWriter extends DocumentWriter<UnfitnessCertificate> {
    /**
     * Consists of names of tokens from file;
     */
    enum Token {
        REASON;

        @Override
        public String toString() {
            return "$" + name();
        }
    }

    /**
     * Constructor
     *
     * @param documentToWrite
     */
    public UnfitnessCertificateWriter(UnfitnessCertificate documentToWrite) {
        super(documentToWrite);
    }

    /**
     * Writes document into the specified file
     */
    public void write() {

    }
}
