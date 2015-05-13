package com.softserve.edu.documentGenerator.documents;

import com.softserve.edu.documentGenerator.utils.Template;
import com.softserve.edu.entity.Verification;

/**
 * Represent an unfitness certificate document
 */
public class UnfitnessCertificate extends BaseDocument {
    private String reasonForUnfitness;

    public String getReasonForUnfitness() {
        return reasonForUnfitness;
    }

    public void setReasonForUnfitness(String reasonForUnfitness) {
        this.reasonForUnfitness = reasonForUnfitness;
    }

    public UnfitnessCertificate(Verification verification) {
        super(Template.UNFITNESS_CERTIFICATE, verification);
    }
}
