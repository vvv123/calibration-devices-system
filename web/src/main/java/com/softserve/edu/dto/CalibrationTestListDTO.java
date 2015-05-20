package com.softserve.edu.dto;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;


public class CalibrationTestListDTO extends ResourceSupport{
    private List<CalibrationTestDTO> calibrationTests = new ArrayList<>();

    public List<CalibrationTestDTO> getCalibrationTests() {
        return calibrationTests;
    }

    public void setCalibrationTests(List<CalibrationTestDTO> calibrationTests) {
        this.calibrationTests = calibrationTests;
    }
}
