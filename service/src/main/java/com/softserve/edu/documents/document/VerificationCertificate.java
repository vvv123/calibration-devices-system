package com.softserve.edu.documents.document;

import com.softserve.edu.documents.options.DocumentType;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;

/**
 * Represents a verification certificate document.
 */
public class VerificationCertificate extends BaseCertificate {
    public VerificationCertificate(Verification verification, CalibrationTest calibrationTest) {
        super(DocumentType.VERIFICATION_CERTIFICATE, verification, calibrationTest);
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
