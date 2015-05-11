package com.softserve.edu.documentGenerator.generator.documents;

import com.softserve.edu.documentGenerator.generator.documents.documentsFields.VerificationCertificateData;

public class VerificationCertificate extends Document  {
    private VerificationCertificateData verificationCertificateData;

    public VerificationCertificateData getVerificationCertificateData() {
        return verificationCertificateData;
    }

    public void setVerificationCertificateData(VerificationCertificateData verificationCertificateData) {
        this.verificationCertificateData = verificationCertificateData;
    }
}
