package com.softserve.edu.documentGenerator.generator.documentWriter;

import com.softserve.edu.documentGenerator.generator.documents.UnfitnessCertificate;
import com.softserve.edu.documentGenerator.generator.documents.documentsFields.UnfitnessReasonData;

import java.io.File;

public class UnfitnessCertificateWriter {
    private UnfitnessCertificate doc;
    private File file;

    public UnfitnessCertificateWriter(UnfitnessCertificate doc, File file) {
        this.doc = doc;
        this.file = file;
    }

    public void write() {
        DocumentWriter documentWriter = new DocumentWriter(doc);
        documentWriter.write(file);

        Writer writer = new Writer();

        UnfitnessReasonData dto = doc.getUnfitnessReasonData();
        //writer.replaceTokenAndSave(file, "$REASON", dto.getReasonForUnfitness());
        writer.replaceTokenAndSave(file, "$REASON", "все супер");
    }
}
