package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.BaseDocument;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DocumentWriter {
    private BaseDocument doc;

    enum Token {
        CALIBRATOR_NAME,
        CALIBRATOR_ADDRESS,
        CALIBRATOR_DATE,
        CALIBRATOR_CERT,
        SERIAL,
        DEVICE_CREATOR,
        OWNER_NAME,
        OWNER_SURNAME,
        LABORATORY_NAME,
        ID,
        DOCUMENT_DATE;

        @Override
        public String toString() {
            return "$" + name();
        }
    }


    public DocumentWriter(BaseDocument doc) {
        this.doc = doc;
    }

    public void write(File file) {
        TokenWriter tokenWriter = new TokenWriter();

        tokenWriter.replaceTokenAndSave(file, Token.CALIBRATOR_NAME.toString(),
                doc.getCalibratorCompanyName());
        tokenWriter.replaceTokenAndSave(file, Token.CALIBRATOR_ADDRESS.toString(),
                doc.getCalibratorAddress());
        Date calibratorDate = doc.getCalibratorCertificateGranted();
        String formatDate = new SimpleDateFormat("dd/MM/yyyy").format(calibratorDate);
        tokenWriter.replaceTokenAndSave(file, Token.CALIBRATOR_DATE.toString(), formatDate);
                System.out.println(formatDate);
        tokenWriter.replaceTokenAndSave(file, Token.CALIBRATOR_CERT.toString(),
                doc.getCalibratorCertificateNumber());

        tokenWriter.replaceTokenAndSave(file, Token.SERIAL.toString(),
                doc.getSerialNumber());
        tokenWriter.replaceTokenAndSave(file, Token.DEVICE_CREATOR.toString(),
                doc.getManufacturer());

        tokenWriter.replaceTokenAndSave(file, Token.OWNER_NAME.toString(), doc.getName());
        tokenWriter.replaceTokenAndSave(file, Token.OWNER_SURNAME.toString(), doc.getSurname());

        tokenWriter.replaceTokenAndSave(file, Token.LABORATORY_NAME.toString(),
                doc.getVerificationLaboratory());

        tokenWriter.replaceTokenAndSave(file, Token.ID.toString(),
                doc.getDocumentNumber());
        Date documentDate = doc.getDocumentDate();

        String documentFormatDate = new SimpleDateFormat("dd/MM/yyyy").format(calibratorDate);
        tokenWriter.replaceTokenAndSave(file, Token.DOCUMENT_DATE.toString(), documentFormatDate);
    }
}
