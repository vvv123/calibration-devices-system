package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.documents.BaseDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;

/**
 * Writes data into a document
 */
public abstract class DocumentWriter {
    private BaseDocument document;
    private File fileToWrite;

    interface Token {
        String getTokenName();
    }

    /**
     * Consists of names of tokens from file;
     */
    enum BaseDocumentToken implements Token {
        CALIBRATOR_COMPANY_NAME,
        VERIFICATOR_COMPANY_NAME,
        CALIBRATOR_COMPANY_ADDRESS,
        CALIBRATOR_ACC_CERT_NAME,
        CALIBRATOR_ACC_CERT_DATE_GRANTED,
        VERIFICATION_CERTIFICATE_NUMBER,
        DEV_NAME,
        DEV_SIGN,
        DEV_MAN_SER,  // device manufacturer serial
        MAN_NAME,
        OWNER_NAME,
        VERIFICATOR_SHORT_NAME;

        @Override
        public String getTokenName() {
            System.out.println("$" + name());
            return "$" + name();
        }
    }

    /**
     * Constructor
     * @param document document to be written to file
     */
    public DocumentWriter(BaseDocument document, File file) {
        this.document = document;
        this.fileToWrite = file;
    }

    /**
     * Write document into the file
     * @throws IOException
     * @throws InvalidFormatException
     */
    public void write() throws IOException, InvalidFormatException {
        TokenWriter tokenWriter = new TokenWriter(fileToWrite);

        writeCalibrator(tokenWriter);
        writeDevice(tokenWriter);
        writeVerificator(tokenWriter);
        writeOwner(tokenWriter);
        writeDocument(tokenWriter);
    }

    /**
     * Write calibrators data to the file
     * @param tokenWriter
     * @throws IOException
     */
    public void writeCalibrator(TokenWriter tokenWriter) throws IOException {
        tokenWriter.replaceToken(BaseDocumentToken.CALIBRATOR_COMPANY_NAME.getTokenName(),
                document.getCalibratorCompanyName());
        tokenWriter.replaceToken(BaseDocumentToken.CALIBRATOR_COMPANY_ADDRESS.getTokenName(),
                document.getCalibratorCompanyAddress());

        tokenWriter.replaceToken(BaseDocumentToken.CALIBRATOR_ACC_CERT_DATE_GRANTED.getTokenName(),
                document.getCalibratorCompanyAccreditationCertificateGrantedDate());

        tokenWriter.replaceToken(BaseDocumentToken.CALIBRATOR_ACC_CERT_NAME.getTokenName(),
                document.getCalibratorCompanyAccreditationCertificateNumber());
    }

    public void writeDevice(TokenWriter tokenWriter) throws IOException {
        tokenWriter.replaceToken(BaseDocumentToken.DEV_MAN_SER.getTokenName(),
                document.getDeviceManufacturerSerial());
        tokenWriter.replaceToken(BaseDocumentToken.MAN_NAME.getTokenName(),
                document.getManufacturerName());
        tokenWriter.replaceToken(BaseDocumentToken.DEV_NAME.getTokenName(),
                document.getDeviceName());
        tokenWriter.replaceToken(BaseDocumentToken.DEV_SIGN.getTokenName(),
                document.getDeviceSign());
    }

    public void writeOwner(TokenWriter tokenWriter) throws IOException {
        tokenWriter.replaceToken(BaseDocumentToken.OWNER_NAME.getTokenName(), document.getOwnerFullName());
    }

    public void writeDocument(TokenWriter tokenWriter) throws IOException {
        tokenWriter.replaceToken(BaseDocumentToken.VERIFICATION_CERTIFICATE_NUMBER.getTokenName(),
                document.getVerificationCertificateNumber());
    }

    public void writeVerificator(TokenWriter tokenWriter) throws IOException {
        tokenWriter.replaceToken(BaseDocumentToken.VERIFICATOR_COMPANY_NAME.getTokenName(),
                document.getStateVerificatorCompanyName());
        tokenWriter.replaceToken(BaseDocumentToken.VERIFICATOR_SHORT_NAME.getTokenName(),
                document.getStateVerificatorShortName());
    }
}
