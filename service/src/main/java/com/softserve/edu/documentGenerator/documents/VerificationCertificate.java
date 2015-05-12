package com.softserve.edu.documentGenerator.documents;

import com.softserve.edu.documentGenerator.documents.documentsFields.VerificationCertificateData;
import com.softserve.edu.documentGenerator.utils.Template;

/**
 * Represents a verification certificate document.
 */
public class VerificationCertificate extends BaseDocument {
    private VerificationCertificateData verificationCertificateData;

    public VerificationCertificate() {
        super(Template.VERIFICATION_CERTIFICATE);
    }

    public VerificationCertificateData getVerificationCertificateData() {
        return verificationCertificateData;
    }

    public void setVerificationCertificateData(VerificationCertificateData verificationCertificateData) {
        this.verificationCertificateData = verificationCertificateData;
    }
}
