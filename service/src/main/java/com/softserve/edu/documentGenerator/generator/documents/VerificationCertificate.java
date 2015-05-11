package com.softserve.edu.documentGenerator.generator.documents;

import com.softserve.edu.documentGenerator.generator.documents.documentsFields.VerificationCertificateData;
import com.softserve.edu.documentGenerator.utils.Template;

public class VerificationCertificate extends Document  {
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
