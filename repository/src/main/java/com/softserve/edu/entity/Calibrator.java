package com.softserve.edu.entity;

import com.softserve.edu.entity.catalogue.Street;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "CALIBRATOR")
public class Calibrator extends Organization {
    @Column(nullable = false)
    private String certificateNumber;

    @Column(nullable = false)
    private Date certificateGrantedDate;

    protected Calibrator() {
        super();
    }

    public Calibrator(String name, String email, String phone, String certificateNumber,
                      Date certificateGrantedDate) {
        super(name, email, phone);

        this.certificateNumber = certificateNumber;
        this.certificateGrantedDate = certificateGrantedDate;
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
}
