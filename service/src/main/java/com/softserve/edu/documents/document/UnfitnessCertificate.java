package com.softserve.edu.documents.document;

import com.softserve.edu.documents.document.meta.Column;
import com.softserve.edu.documents.options.DocumentType;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;

/**
 * Represents an unfitness certificate document.
 */
public class UnfitnessCertificate extends BaseCertificate {
    /**
     * Constructor.
     *
     * @param verification    entity to get document's data from
     * @param calibrationTest one of calibration test that is assigned to the verification
     */
    public UnfitnessCertificate(Verification verification, CalibrationTest calibrationTest) {
        super(DocumentType.UNFITNESS_CERTIFICATE, verification, calibrationTest);
    }

    @Override
    @Column(name = "UNFITNESS_CERTIFICATE_NUMBER")
    public String getVerificationCertificateNumber() {
        return String.valueOf(getVerification().getId());
    }

    /**
     * @return the date until this verification certificate is effective.
     */
    @Column(name = "EFF_DATE")
    public String getVerificationCertificateDate() {
        return getVerification().getVerificationFinishedDate().toString();
    }
}
