package com.softserve.edu.documentGenerator.documents;

import com.softserve.edu.documentGenerator.documents.documentsFields.UnfitnessReasonData;
import com.softserve.edu.documentGenerator.utils.Template;

/**
 * Represent an unfitness certificate document
 */
public class UnfitnessCertificate extends BaseDocument {
    private UnfitnessReasonData unfitnessReasonData;

    public UnfitnessCertificate() {
        super(Template.UNFITNESS_CERTIFICATE);
    }

    public UnfitnessReasonData getUnfitnessReasonData() {
        return unfitnessReasonData;
    }

    public void setUnfitnessReasonData(UnfitnessReasonData unfitnessReasonData) {
        this.unfitnessReasonData = unfitnessReasonData;
    }
}
