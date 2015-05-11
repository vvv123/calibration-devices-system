package com.softserve.edu.documentGenerator.generator.documents;

import com.softserve.edu.documentGenerator.generator.documents.documentsFields.*;

public abstract class Document {
    private Calibrator calibrator;
    private Document DTO;
    private Device device;
    private Person owner;
    private Laboratory laboratory;

    public Calibrator getCalibrator() {
        return calibrator;
    }

    public void setCalibrator(Calibrator calibrator) {
        this.calibrator = calibrator;
    }

    public Document getDTO() {
        return DTO;
    }

    public void setDTO(Document DTO) {
        this.DTO = DTO;
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
