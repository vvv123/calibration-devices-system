package com.softserve.edu.dto.application;

import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.ClientData;

public class ClientStageVerificationDTO {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private String region;
    private String locality;
    private String district;
    private String street;
    private String building;
    private String flat;
    private Long providerId;

    protected ClientStageVerificationDTO() {}

    public ClientStageVerificationDTO(ClientData clientData, Address address, Long providerId) {
        this.firstName = clientData.getFirstName();
        this.lastName = clientData.getLastName();
        this.middleName = clientData.getMiddleName();
        this.email = clientData.getEmail();
        this.phone = clientData.getPhone();
        this.region = address.getRegion();
        this.locality = address.getLocality();
        this.district = address.getDistrict();
        this.street = address.getStreet();
        this.building = address.getBuilding();
        this.flat = address.getFlat();
        this.providerId = providerId;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
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

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }
}
