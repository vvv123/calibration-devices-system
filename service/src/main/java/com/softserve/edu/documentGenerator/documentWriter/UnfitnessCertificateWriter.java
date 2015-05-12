package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.UnfitnessCertificate;

import java.io.File;

/**
 * Class for writing an unfitness certificate into a template file
 * Writer for unfitness certificate.
 */
public class UnfitnessCertificateWriter {
    private UnfitnessCertificate doc;
    private File file;

    enum Token {
        REASON;

        @Override
        public String toString() {
            return "$" + name();
        }
    }

    public UnfitnessCertificateWriter(UnfitnessCertificate doc, File file) {
        this.doc = doc;
        this.file = file;
    }

    /**
     * Write document into the specified file
     */
    public void write() {
        DocumentWriter documentWriter = new DocumentWriter(doc);
        documentWriter.write(file);

        TokenWriter tokenWriter = new TokenWriter();

        //UnfitnessReasonData dto = doc.getUnfitnessReasonData();
        //tokenWriter.replaceTokenAndSave(file, "$REASON", dto.getReasonForUnfitness());
        tokenWriter.replaceTokenAndSave(file, Token.REASON.toString(), "все супер");
    }
}
