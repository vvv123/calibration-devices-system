package com.softserve.edu.dto;


import com.softserve.edu.documents.options.DocumentFormat;
import com.softserve.edu.documents.options.DocumentType;

public class DocumentDTO {
    private DocumentType documentType;

    private Long verificationID;

    private Long testID;

    private DocumentFormat format;

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Long getVerificationID() {
        return verificationID;
    }

    public void setVerificationID(Long verificationID) {
        this.verificationID = verificationID;
    }

    public Long getTestID() {
        return testID;
    }

    public void setTestID(Long testID) {
        this.testID = testID;
    }

    public DocumentFormat getFormat() {
        return format;
    }

    public void setFormat(DocumentFormat format) {
        this.format = format;
    }
}
