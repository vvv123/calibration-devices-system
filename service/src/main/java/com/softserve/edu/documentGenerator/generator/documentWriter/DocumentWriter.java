package com.softserve.edu.documentGenerator.generator.documentWriter;

import com.softserve.edu.documentGenerator.generator.documents.Document;
import com.softserve.edu.documentGenerator.generator.documents.documentsFields.Calibrator;

import java.io.File;

public class DocumentWriter {
    private Document doc;

    public DocumentWriter(Document doc) {
        this.doc = doc;
    }

    public void write(File file) {
        Writer writer = new Writer();

        Long verificationID = doc.getVerificationID();
        writer.replaceTokenAndSave(file, "$ID", String.valueOf(verificationID));

        Calibrator calibrator = doc.getCalibrator();
        writer.replaceTokenAndSave(file, "$CALIBRATOR_NAME", calibrator.getCalibratorCompanyName());
        writer.replaceTokenAndSave(file, "$CALIBRATOR_ADDRESS", calibrator.getCalibratorAddress());
        writer.replaceTokenAndSave(file, "$CALIBRATOR_DATE",
                calibrator.getCalibratorCertificateGranted().toString());
        writer.replaceTokenAndSave(file, "$CALIBRATOR_CERT", calibrator.getCalibratorCertificateNumber().toString());
    }
}
