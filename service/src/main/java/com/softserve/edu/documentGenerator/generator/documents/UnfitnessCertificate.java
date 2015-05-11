package com.softserve.edu.documentGenerator.generator.documents;

import com.softserve.edu.documentGenerator.generator.documents.documentsFields.UnfitnessReasonData;
import com.softserve.edu.documentGenerator.utils.Template;

public class UnfitnessCertificate extends Document {
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
