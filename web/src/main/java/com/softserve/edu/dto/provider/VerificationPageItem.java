package com.softserve.edu.dto.provider;

import java.util.Date;

public class VerificationPageItem {
    private String id;
    private Date date;
    private String surname;
    private String street;

    public VerificationPageItem() {
    }

    public VerificationPageItem(String id, Date date, String surname, String street) {
        this.id = id;
        this.date =date;
        this.surname = surname;
        this.street = street;
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
}
