package com.softserve.edu.entity;

import com.softserve.edu.entity.catalogue.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    // Optional
    private String flatNumber;

    @ManyToOne(optional = false)
    private Building building;

    @ManyToOne(optional = false)
    private Street street;

    @ManyToOne(optional = false)
    private Locality locality;

    @ManyToOne(optional = false)
    private District district;

    @ManyToOne(optional = false)
    private Region region;

    public Address() {}

    public Address(String flatNumber, Building building, Street street,
                   Locality locality, District district, Region region) {
        this.flatNumber = flatNumber;
        this.building = building;
        this.street = street;
        this.locality = locality;
        this.district = district;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
