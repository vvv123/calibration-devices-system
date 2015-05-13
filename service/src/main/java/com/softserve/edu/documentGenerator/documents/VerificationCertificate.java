package com.softserve.edu.documentGenerator.documents;

import com.softserve.edu.documentGenerator.utils.Template;
import com.softserve.edu.entity.Verification;

/**
 * Represents a verification certificate document.
 */
public class VerificationCertificate extends BaseDocument {

    public VerificationCertificate(Template template, Verification verification) {
        super(Template.VERIFICATION_CERTIFICATE, verification);
    }

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
