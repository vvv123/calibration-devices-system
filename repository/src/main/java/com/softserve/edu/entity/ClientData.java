package com.softserve.edu.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class ClientData {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;

    @Embedded
    private Address clientAddress;

    protected ClientData() {}

    public ClientData(String firstName, String lastName, String middleName, String email, String phone, Address
            clientAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phone = phone;
        this.clientAddress = clientAddress;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
