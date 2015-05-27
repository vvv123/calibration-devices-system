package com.softserve.edu.entity;

import com.softserve.edu.entity.catalogue.Street;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "CALIBRATOR")
public class Calibrator extends Organization {
    /**
     * Identification number of the certificate that allows this calibrator to
     * perform verifications.
     */
    //@Column(nullable = false)
    private String certificateNumber;

    /**
     * Identification number of the certificate that allows this calibrator to
     * perform verifications.
     */
    //@Column(nullable = false)
    private Date certificateGrantedDate;

    protected Calibrator() {
        super();
    }

    public Calibrator(String name, String email, String phone) {
        super(name, email, phone);
    }

    public Calibrator(String name, String email, String phone, Address address) {
        super(name, email, phone, address);
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public Date getCertificateGrantedDate() {
        return certificateGrantedDate;
    }

    public void setCertificateGrantedDate(Date certificateGrantedDate) {
        this.certificateGrantedDate = certificateGrantedDate;
    }

    @Override
    public String toString() {
        return "Calibrator{" +
                "certificateNumber='" + certificateNumber + '\'' +
                ", certificateGrantedDate=" + certificateGrantedDate +
                '}';
    }
}
