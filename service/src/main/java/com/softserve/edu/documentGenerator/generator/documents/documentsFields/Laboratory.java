package com.softserve.edu.documentGenerator.generator.documents.documentsFields;

/**
 * Created by oleg on 5/11/15.
 */
public class Laboratory {
    private String verificationLaboratory; // optional
    private Person verificationLaboratoryHead;

    public String getVerificationLaboratory() {
        return verificationLaboratory;
    }

    public void setVerificationLaboratory(String verificationLaboratory) {
        this.verificationLaboratory = verificationLaboratory;
    }

    public Person getVerificationLaboratoryHead() {
        return verificationLaboratoryHead;
    }

    public void setVerificationLaboratoryHead(Person verificationLaboratoryHead) {
        this.verificationLaboratoryHead = verificationLaboratoryHead;
    }
}
