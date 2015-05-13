package com.softserve.edu.documentGenerator.documents;

import com.softserve.edu.documentGenerator.utils.Template;
import com.softserve.edu.entity.Verification;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * Represents a base document.
 * All real documents extend from this class.
 */
public abstract class BaseDocument {
    private Verification verification;
    private Template template;

    public BaseDocument(Template template, Verification verification) {
        this.template = template;
        setVerification(verification);
    }

    public Template getTemplate() {
        return template;
    }

    public Verification getVerification() {
        return verification;
    }

    private void setVerification(Verification verification) {
        Assert.notNull(verification, "Error");
        this.verification = verification;
    }

    public String getCalibratorCompanyName() {
        return verification.getCalibrator().getName();
    }

    public String getCalibratorAddress() {
        return verification.getCalibrator().getAddress().toString();
    }

    public Date getCalibratorCertificateGranted() {
        return new Date();
    }

    public String getCalibratorCertificateNumber() {
        return "11";
    }

    public String getSerialNumber() {
        return verification.getDevice().getId().toString();
    }

    public String getManufacturer() {
        return verification.getDevice().getManufacturer().toString();
    }

    public String getName() {
        return verification.getCalibratorEmployee().getFirstName();
    }

    public String getSurname() {
        return verification.getCalibratorEmployee().getLastName();
    }

    public String getVerificationLaboratory() {
        return verification.getStateVerificator().getName();
    }

    public String getDocumentNumber() {
        return verification.getId().toString();
    }

    public Date getDocumentDate() {
        return new Date();
    }

    public String getDeviceName() {
        return getVerification().getDevice().getDeviceType().toString();
    }
}
