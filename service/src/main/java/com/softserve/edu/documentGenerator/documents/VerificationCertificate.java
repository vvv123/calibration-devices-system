package com.softserve.edu.documentGenerator.documents;

import com.softserve.edu.documentGenerator.documentWriter.VerificationCertificateWriter;
import com.softserve.edu.documentGenerator.documentWriter.Writer;
import com.softserve.edu.documentGenerator.utils.DocumentType;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;

/**
 * Represents a verification certificate document.
 */
public class VerificationCertificate extends BaseDocument {

    @Override
    public Writer getWriter() {
        return new VerificationCertificateWriter(this);
    }

    public VerificationCertificate(Verification verification, CalibrationTest calibrationTest) {
        super(DocumentType.VERIFICATION_CERTIFICATE, verification, calibrationTest);
        setWriter(new VerificationCertificateWriter(this));
    }

    /**
     * @return the date until this verification certificate is effective.
     */
    public String getVerificationCertificateEffectiveUntilDate() {
        return getVerification().getVerificationFinishedDate().toString();
    }

    /**
     * @return get the sign of the document, which contains the metrological characteristics
     */
    public String getMetrologicalDocumentSign() {
        return getCalibrationTest().getMetrologicalDocument().getSign();
    }

    /**
     * @return get the name of the document, which contains the metrological characteristics
     */
    public String getMetrologicalDocumentName() {
        return getCalibrationTest().getMetrologicalDocument().getName();
    }
}
