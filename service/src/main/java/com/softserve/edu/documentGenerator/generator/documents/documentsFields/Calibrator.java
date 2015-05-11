package com.softserve.edu.documentGenerator.generator.documents.documentsFields;

import java.util.Date;

/**
 * Created by oleg on 5/11/15.
 */
public class Calibrator {
    private String calibratorCompanyName;
    private String calibratorAddress;
    private Date calibratorCertificatGranted;   // no info in db
    private Integer calibratorCertificatNumber; // no info in db
    private String calibratorEmployeeSign;
    private String calibratorEmployeeNameSurname;

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

    public Date getCalibratorCertificatGranted() {
        return calibratorCertificatGranted;
    }

    public void setCalibratorCertificatGranted(Date calibratorCertificatGranted) {
        this.calibratorCertificatGranted = calibratorCertificatGranted;
    }

    public Integer getCalibratorCertificatNumber() {
        return calibratorCertificatNumber;
    }

    public void setCalibratorCertificatNumber(Integer calibratorCertificatNumber) {
        this.calibratorCertificatNumber = calibratorCertificatNumber;
    }

    public String getCalibratorEmployeeSign() {
        return calibratorEmployeeSign;
    }

    public void setCalibratorEmployeeSign(String calibratorEmployeeSign) {
        this.calibratorEmployeeSign = calibratorEmployeeSign;
    }

    public String getCalibratorEmployeeNameSurname() {
        return calibratorEmployeeNameSurname;
    }

    public void setCalibratorEmployeeNameSurname(String calibratorEmployeeNameSurname) {
        this.calibratorEmployeeNameSurname = calibratorEmployeeNameSurname;
    }
}
