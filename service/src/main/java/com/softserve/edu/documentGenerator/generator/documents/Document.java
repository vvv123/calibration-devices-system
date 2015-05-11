package com.softserve.edu.documentGenerator.generator.documents;

import com.softserve.edu.documentGenerator.generator.documents.documentsFields.*;
import com.softserve.edu.documentGenerator.utils.Template;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Document {
    private Long VerificationID;
    private Template template;
    private Calibrator calibrator;
    private DocumentData documentData;
    private Device device;
    private Person owner;
    private Laboratory laboratory;

    public Document(Template template) {
        this.template = template;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Document document = (Document) o;

        return new EqualsBuilder()
                .append(VerificationID, document.VerificationID)
                .append(template, document.template)
                .append(calibrator, document.calibrator)
                .append(documentData, document.documentData)
                .append(device, document.device)
                .append(owner, document.owner)
                .append(laboratory, document.laboratory)
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
