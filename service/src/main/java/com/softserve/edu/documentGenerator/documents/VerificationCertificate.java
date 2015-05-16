package com.softserve.edu.documentGenerator.documents;

import com.softserve.edu.documentGenerator.utils.Template;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;

/**
 * Represents a verification certificate document.
 */
public class VerificationCertificate extends BaseDocument {

    public VerificationCertificate(Template template, Verification verification, CalibrationTest calibrationTest) {
        super(Template.VERIFICATION_CERTIFICATE, verification, calibrationTest);
    }

    /**
     * @return the date until this verification certificate is effective.
     */
    public String getVerificationCertificateEffectiveUntilDate() {
        // TODO: how long is certificate effective?
        return getVerification().getVerificationFinishedDate().toString();
    }

    public String getDocumentId() {
        return getVerification().getId().toString();
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
