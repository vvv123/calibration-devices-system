package com.softserve.edu.documentGenerator.documents;

import com.softserve.edu.documentGenerator.documentWriter.UnfitnessCertificateWriter;
import com.softserve.edu.documentGenerator.utils.DocumentType;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;

/**
 * Represents an unfitness certificate document.
 */
public class UnfitnessCertificate extends BaseDocument {
    /**
     * Constructor.
     *
     * @param verification    entity to get document's data from
     * @param calibrationTest one of calibration test that is assigned to the verification
     */
    public UnfitnessCertificate(Verification verification, CalibrationTest calibrationTest) {
        super(DocumentType.UNFITNESS_CERTIFICATE, verification, calibrationTest);
        setWriter(new UnfitnessCertificateWriter(this));
    }

    /**
     * @return the date until this verification certificate is effective.
     */
    public String getVerificationCertificateDate() {
        return getVerification().getVerificationFinishedDate().toString();
    }
}
