package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.BaseDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
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
        DOC_DATE,
        DEV_NAME;

        @Override
        public String toString() {
            return "$" + name();
        }
    }

    public DocumentWriter(BaseDocument doc) {
        this.doc = doc;
    }

    public void write(File file) throws IOException, InvalidFormatException {
        TokenWriter tokenWriter = new TokenWriter();

        tokenWriter.replaceToken(file, Token.CALIBRATOR_NAME.toString(),
                doc.getCalibratorCompanyName());
        tokenWriter.replaceToken(file, Token.CALIBRATOR_ADDRESS.toString(),
                doc.getCalibratorAddress());
        Date calibratorDate = doc.getCalibratorCertificateGranted();
        String formatDate = new SimpleDateFormat("dd/MM/yyyy").format(calibratorDate);

        tokenWriter.replaceToken(file, Token.CALIBRATOR_DATE.toString(), formatDate);
                System.out.println(formatDate);
        tokenWriter.replaceToken(file, Token.CALIBRATOR_CERT.toString(),
                doc.getCalibratorCertificateNumber());

        tokenWriter.replaceToken(file, Token.SERIAL.toString(),
                doc.getSerialNumber());
        tokenWriter.replaceToken(file, Token.DEVICE_CREATOR.toString(),
                doc.getManufacturer());

        tokenWriter.replaceToken(file, Token.OWNER_NAME.toString(), doc.getName());
        tokenWriter.replaceToken(file, Token.OWNER_SURNAME.toString(), doc.getSurname());

        tokenWriter.replaceToken(file, Token.LABORATORY_NAME.toString(),
                doc.getVerificationLaboratory());

        tokenWriter.replaceToken(file, Token.DEV_NAME.toString(),
                doc.getDeviceName());

        tokenWriter.replaceToken(file, Token.ID.toString(),
                doc.getDocumentNumber());
        Date documentDate = doc.getDocumentDate();

        String documentFormatDate = new SimpleDateFormat("dd/MM/yyyy").format(doc.getDocumentDate());
        tokenWriter.replaceToken(file, Token.DOC_DATE.toString(), documentFormatDate);
    }
}
