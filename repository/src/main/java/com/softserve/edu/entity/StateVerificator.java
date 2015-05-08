package com.softserve.edu.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "STATE_VERIFICATION")
public class StateVerificator extends Organization {
}
