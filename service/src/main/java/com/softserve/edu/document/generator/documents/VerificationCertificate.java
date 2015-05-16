package com.softserve.edu.document.generator.documents;

import com.softserve.edu.document.generator.utils.Template;
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

    /**
     * @return the number of the page, which contains an additional info for this document
     */
//    public String getAdditionalInfoPage() {
//        return
//    }

    public Integer getAdditionalInfoPageNumber() {
        return null;
    }

    public String getDocumentId() {
        return getVerification().getId().toString();
    }

    public String getSpecificationDocumentName() {
        return null;
    }
}
