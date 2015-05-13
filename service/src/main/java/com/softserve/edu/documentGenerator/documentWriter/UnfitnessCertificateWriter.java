package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.UnfitnessCertificate;

import java.io.File;

/**
 * Class for writing an unfitness certificate into a template file
 * Writer for unfitness certificate.
 */
public class UnfitnessCertificateWriter {
    private UnfitnessCertificate documentToWrite;
    private File fileToWrite;

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
     * @param documentToWrite
     * @param fileToWrite
     */
    public UnfitnessCertificateWriter(UnfitnessCertificate documentToWrite, File fileToWrite) {
        this.documentToWrite = documentToWrite;
        this.fileToWrite = fileToWrite;
    }

    /**
     * Writes document into the specified file
     */
    public void write() {

    }
}
