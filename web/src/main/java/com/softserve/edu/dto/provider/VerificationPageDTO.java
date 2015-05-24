package com.softserve.edu.dto.provider;

import com.softserve.edu.entity.util.Status;

import java.util.Date;

public class VerificationPageDTO {
    private String id;
    private Date date;
    private String surname;
    private String street;
    private Status status;

    public VerificationPageDTO() {}

    public VerificationPageDTO(String id, Date date, String surname, String street, Status status) {
        this.id = id;
        this.date = date;
        this.surname = surname;
        this.street = street;
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
