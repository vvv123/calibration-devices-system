package com.softserve.edu.dto;

import com.softserve.edu.entity.CalibrationTestData;
import org.springframework.hateoas.ResourceSupport;


public class CalibrationTestDataDTO extends ResourceSupport {

    private double actualConsumption;

    public double getActualConsumption() {
        return actualConsumption;
    }

    public void setActualConsumption(double actualConsumption) {
        this.actualConsumption = actualConsumption;
    }

    public CalibrationTestData toTestData() {
        CalibrationTestData calibrationTestData = new CalibrationTestData();
        calibrationTestData.setActualConsumption(actualConsumption);
        return calibrationTestData;
    }

}