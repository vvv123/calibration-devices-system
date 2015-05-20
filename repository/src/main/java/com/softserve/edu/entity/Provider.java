package com.softserve.edu.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PROVIDER")
public class Provider extends Organization {
    public Provider(String name, String email, String phone) {
        super(name, email, phone);
    }

    public Provider(String name, String email, String phone, Address address) {
        super(name, email, phone, address);
    }

    public Provider() {}
}
