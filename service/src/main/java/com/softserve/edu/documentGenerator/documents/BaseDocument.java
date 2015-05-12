package com.softserve.edu.documentGenerator.documents;

import com.softserve.edu.documentGenerator.documents.documentsFields.*;
import com.softserve.edu.documentGenerator.utils.Template;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Represents a base document.
 * All real documents extend from this class.
 */
public abstract class BaseDocument {
    private Long VerificationID;
    private Template template;
    private Calibrator calibrator;
    private DocumentData documentData;
    private Device device;
    private Person owner;
    private Laboratory laboratory;

    public BaseDocument(Template template) {
        this.template = template;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        BaseDocument baseDocument = (BaseDocument) o;

        return new EqualsBuilder()
                .append(VerificationID, baseDocument.VerificationID)
                .append(template, baseDocument.template)
                .append(calibrator, baseDocument.calibrator)
                .append(documentData, baseDocument.documentData)
                .append(device, baseDocument.device)
                .append(owner, baseDocument.owner)
                .append(laboratory, baseDocument.laboratory)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(VerificationID)
                .append(template)
                .append(calibrator)
                .append(documentData)
                .append(device)
                .append(owner)
                .append(laboratory)
                .toHashCode();
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Long getVerificationID() {
        return VerificationID;
    }

    public void setVerificationID(Long verificationID) {
        VerificationID = verificationID;
    }

    public Calibrator getCalibrator() {
        return calibrator;
    }

    public void setCalibrator(Calibrator calibrator) {
        this.calibrator = calibrator;
    }

    public DocumentData getDocumentData() {
        return documentData;
    }

    public void setDocumentData(DocumentData documentData) {
        this.documentData = documentData;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }
}
