package com.softserve.edu.entity;

import javax.persistence.Embeddable;

/**
 * Document that contains the metrological requirements for testing a device
 */
@Embeddable
public class MetrologicalDocument {
    private String name;
    private String sign;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
