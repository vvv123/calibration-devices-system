package com.softserve.edu.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Oles Onyshchak on 5/8/2015.
 */
@Embeddable
public class ClientData {
    private String name;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private String code;

    @Embedded
    private Address clientAddress;

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String code() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getMiddleName() != null ? getMiddleName().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        return String.valueOf(result);
    }
}
