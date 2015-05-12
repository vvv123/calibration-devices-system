package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.documents.documentsFields.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DocumentWriter {
    private BaseDocument doc;

    public DocumentWriter(BaseDocument doc) {
        this.doc = doc;
    }

    public void write(File file) {
        TokenWriter tokenWriter = new TokenWriter();

        Calibrator calibrator = doc.getCalibrator();
        tokenWriter.replaceTokenAndSave(file, "$CALIBRATOR_NAME", calibrator.getCalibratorCompanyName());
        tokenWriter.replaceTokenAndSave(file, "$CALIBRATOR_ADDRESS", calibrator.getCalibratorAddress());
        Date calibratorDate = calibrator.getCalibratorCertificateGranted();
        String formatDate = new SimpleDateFormat("dd/MM/yyyy").format(calibratorDate);
        tokenWriter.replaceTokenAndSave(file, "$CALIBRATOR_DATE", formatDate);
        System.out.println(formatDate);
        tokenWriter.replaceTokenAndSave(file, "$CALIBRATOR_CERT", calibrator.getCalibratorCertificateNumber().toString());

        Device device = doc.getDevice();
        tokenWriter.replaceTokenAndSave(file, "$SERIAL", device.getSerialNumber().toString());
        tokenWriter.replaceTokenAndSave(file, "$DEVICE_CREATOR", device.getManufacturer());

        Person owner = doc.getOwner();
        tokenWriter.replaceTokenAndSave(file, "$OWNER_NAME", owner.getName());
        tokenWriter.replaceTokenAndSave(file, "$OWNER_SURNAME", owner.getSurname());

        Laboratory laboratory = doc.getLaboratory();
        tokenWriter.replaceTokenAndSave(file, "$LABORATORY_NAME", laboratory.getVerificationLaboratory());

        DocumentData documentData = doc.getDocumentData();
        tokenWriter.replaceTokenAndSave(file, "$ID", documentData.getDocumentNumber().toString());
        Date documentDate = documentData.getDocumentDate();
        String documentFormatDate = new SimpleDateFormat("dd/MM/yyyy").format(calibratorDate);
        tokenWriter.replaceTokenAndSave(file, "$DOCUMENT_DATE", documentFormatDate);
    }
}
