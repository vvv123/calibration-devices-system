package com.softserve.edu.document.generator.writer;

import com.softserve.edu.document.generator.documents.BaseDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;

/**
 * Writes data into a document
 */
public abstract class DocumentWriter {
    private BaseDocument document;
    private File fileToWrite;

    /**
     * Consists of names of tokens from file;
     */
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
        writeLaboratory(tokenWriter);
        writeOwner(tokenWriter);
        writeDocument(tokenWriter);
    }

    /**
     * Write calibrators data to the file
     * @param tokenWriter
     * @throws IOException
     */
    public void writeCalibrator(TokenWriter tokenWriter) throws IOException {
//        tokenWriter.replaceToken(Token.CALIBRATOR_NAME.toString(),
//                document.getCalibratorCompanyName());
//        tokenWriter.replaceToken(Token.CALIBRATOR_ADDRESS.toString(),
//                document.getCalibratorAddress());
//
//        Date calibratorDate = document.getCalibratorCertificateGranted();
//        String formatDate = new SimpleDateFormat("dd/MM/yyyy").format(calibratorDate);
//        tokenWriter.replaceToken(Token.CALIBRATOR_DATE.toString(), formatDate);
//
//        tokenWriter.replaceToken(Token.CALIBRATOR_CERT.toString(),
//                document.getCalibratorCertificateNumber());
    }

    public void writeDevice(TokenWriter tokenWriter) throws IOException {
//        tokenWriter.replaceToken(Token.SERIAL.toString(),
//                document.getSerialNumber());
//        tokenWriter.replaceToken(Token.DEVICE_CREATOR.toString(),
//                document.getManufacturer());
//        tokenWriter.replaceToken(Token.DEV_NAME.toString(),
//                document.getDeviceName());
    }

    public void writeOwner(TokenWriter tokenWriter) throws IOException {
//        tokenWriter.replaceToken(Token.OWNER_NAME.toString(), document.getName());
//        tokenWriter.replaceToken(Token.OWNER_SURNAME.toString(), document.getSurname());
    }

    public void writeDocument(TokenWriter tokenWriter) throws IOException {
//        tokenWriter.replaceToken(Token.ID.toString(),
//                document.getDocumentNumber());
//
//        Date documentDate = document.getDocumentDate();
//        String documentFormatDate = new SimpleDateFormat("dd/MM/yyyy").format(documentDate);
//        tokenWriter.replaceToken(Token.DOC_DATE.toString(), documentFormatDate);
    }

    public void writeLaboratory(TokenWriter tokenWriter) throws IOException {
//        tokenWriter.replaceToken(Token.LABORATORY_NAME.toString(),
//                document.getVerificationLaboratory());
    }
}
