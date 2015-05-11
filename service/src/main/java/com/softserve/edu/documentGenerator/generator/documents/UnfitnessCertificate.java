package com.softserve.edu.documentGenerator.generator.documents;

import com.softserve.edu.documentGenerator.generator.documents.documentsFields.UnfitnessReasonData;

public class UnfitnessCertificate extends Document {
    private UnfitnessReasonData unfitnessReasonData;

    public UnfitnessReasonData getUnfitnessReasonData() {
        return unfitnessReasonData;
    }

    public void setUnfitnessReasonData(UnfitnessReasonData unfitnessReasonData) {
        this.unfitnessReasonData = unfitnessReasonData;
    }
}
