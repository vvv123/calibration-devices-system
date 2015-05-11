package com.softserve.edu.documentGenerator.generator.documents.documentsFields;

import java.util.Date;

/**
 * Created by oleg on 5/11/15.
 */
public class Calibrator {
    private String calibratorCompanyName;
    private String calibratorAddress;
    private Date calibratorCertificateGranted;   // no info in db
    private Integer calibratorCertificateNumber; // no info in db
    private Person calibratorEmployee;

    public String getCalibratorCompanyName() {
        return calibratorCompanyName;
    }

    public void setCalibratorCompanyName(String calibratorCompanyName) {
        this.calibratorCompanyName = calibratorCompanyName;
    }

    public String getCalibratorAddress() {
        return calibratorAddress;
    }

    public void setCalibratorAddress(String calibratorAddress) {
        this.calibratorAddress = calibratorAddress;
    }

    public Date getCalibratorCertificateGranted() {
        return calibratorCertificateGranted;
    }

    public void setCalibratorCertificateGranted(Date calibratorCertificateGranted) {
        this.calibratorCertificateGranted = calibratorCertificateGranted;
    }

    public Integer getCalibratorCertificateNumber() {
        return calibratorCertificateNumber;
    }

    public void setCalibratorCertificateNumber(Integer calibratorCertificateNumber) {
        this.calibratorCertificateNumber = calibratorCertificateNumber;
    }

    public Person getCalibratorEmployee() {
        return calibratorEmployee;
    }

    public void setCalibratorEmployee(Person calibratorEmployee) {
        this.calibratorEmployee = calibratorEmployee;
    }
}
