package com.softserve.edu.document.generator.documents;

import com.softserve.edu.document.generator.utils.Template;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;

/**
 * Represent an unfitness certificate document
 */
public class UnfitnessCertificate extends BaseDocument {
    private String reasonForUnfitness;

    public UnfitnessCertificate(Verification verification, CalibrationTest calibrationTest) {
        super(Template.UNFITNESS_CERTIFICATE, verification, calibrationTest);
    }

    /**
     * @return the date until this verification certificate is effective.
     */
    public String getVerificationCertificateEffectiveUntilDate() {
        return getVerification().getVerificationFinishedDate().toString();
    }

    public String getReasonForUnfitness() {
        return reasonForUnfitness;
    }

    public void setReasonForUnfitness(String reasonForUnfitness) {
        this.reasonForUnfitness = reasonForUnfitness;
    }
}
