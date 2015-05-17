package com.softserve.edu.documentGenerator.Writer;

import com.softserve.edu.documentGenerator.documents.BaseDocument;

/**
 * Writes data into a document
 */
public abstract class DocumentWriter<T extends BaseDocument> implements Writer {
    private T document;

    public T getDocument() {
        return document;
    }

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
            return "$" + name();
        }
    }

    /**
     * Constructor
     *
     * @param document document to be written to file
     */
    public DocumentWriter(T document) {
        this.document = document;
    }

    public String replaceTokens(String text) {
        text = writeCalibrator(text);
        text = writeDevice(text);
        text = writeVerificator(text);
        text = writeOwner(text);
        text = writeDocument(text);

        return text;
    }

    /**
     * Write calibrators data to the file
     */
    public String writeCalibrator(String text) {
        text = text.replace(BaseDocumentToken.CALIBRATOR_COMPANY_NAME.getTokenName(),
                document.getCalibratorCompanyName());
        text = text.replace(BaseDocumentToken.CALIBRATOR_COMPANY_ADDRESS.getTokenName(),
                document.getCalibratorCompanyAddress());

        text = text.replace(BaseDocumentToken.CALIBRATOR_ACC_CERT_DATE_GRANTED.getTokenName(),
                document.getCalibratorCompanyAccreditationCertificateGrantedDate());

        text = text.replace(BaseDocumentToken.CALIBRATOR_ACC_CERT_NAME.getTokenName(),
                document.getCalibratorCompanyAccreditationCertificateNumber());

        return text;
    }

    public String writeDevice(String text) {
        text = text.replace(BaseDocumentToken.DEV_MAN_SER.getTokenName(),
                document.getDeviceManufacturerSerial());
        text = text.replace(BaseDocumentToken.MAN_NAME.getTokenName(),
                document.getManufacturerName());
        text = text.replace(BaseDocumentToken.DEV_NAME.getTokenName(),
                document.getDeviceName());
        text = text.replace(BaseDocumentToken.DEV_SIGN.getTokenName(),
                document.getDeviceSign());

        return text;
    }

    public String writeOwner(String text) {
        text = text.replace(BaseDocumentToken.OWNER_NAME.getTokenName(), document.getOwnerFullName());

        return text;
    }

    public String writeDocument(String text) {
        text = text.replace(BaseDocumentToken.VERIFICATION_CERTIFICATE_NUMBER.getTokenName(),
                document.getVerificationCertificateNumber());

        return text;
    }

    public String writeVerificator(String text) {
        text = text.replace(BaseDocumentToken.VERIFICATOR_COMPANY_NAME.getTokenName(),
                document.getStateVerificatorCompanyName());
        text = text.replace(BaseDocumentToken.VERIFICATOR_SHORT_NAME.getTokenName(),
                document.getStateVerificatorShortName());

        return text;
    }
}
