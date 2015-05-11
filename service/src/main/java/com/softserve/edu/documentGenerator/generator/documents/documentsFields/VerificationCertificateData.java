package com.softserve.edu.documentGenerator.generator.documents.documentsFields;

/**
 * Created by oleg on 5/11/15.
 */
public class VerificationCertificateData {
    private String documentId;
    private String specificationDocumentName;
    private Integer additionalInfoPageNumber;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getSpecificationDocumentName() {
        return specificationDocumentName;
    }

    public void setSpecificationDocumentName(String specificationDocumentName) {
        this.specificationDocumentName = specificationDocumentName;
    }

    public Integer getAdditionalInfoPageNumber() {
        return additionalInfoPageNumber;
    }

    public void setAdditionalInfoPageNumber(Integer additionalInfoPageNumber) {
        this.additionalInfoPageNumber = additionalInfoPageNumber;
    }
}
