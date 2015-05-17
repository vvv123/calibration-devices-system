package com.softserve.edu.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "STATE_VERIFICATION")
public class StateVerificator extends Organization {
    public StateVerificator(String name, String email, String phone) {
        super(name, email, phone);
    }

    public StateVerificator(String name, String email, String phone, Address address) {
        super(name, email, phone, address);
    }

    public StateVerificator() {
        super();
    }
}
