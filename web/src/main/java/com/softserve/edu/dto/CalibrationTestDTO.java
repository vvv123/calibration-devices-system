package com.softserve.edu.dto;

import com.softserve.edu.entity.CalibrationTest;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


public class CalibrationTestDTO extends ResourceSupport {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CalibrationTest toCalibrationTest() {
        CalibrationTest calibrationTest = new CalibrationTest();
        calibrationTest.setName(name);
        return calibrationTest;
    }
}
