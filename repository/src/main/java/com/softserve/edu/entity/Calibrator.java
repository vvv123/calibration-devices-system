package com.softserve.edu.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CALIBRATOR")
public class Calibrator extends Organization {

}
