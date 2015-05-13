package com.softserve.edu.service.utils;

import com.softserve.edu.entity.CalibrationTest;

import java.util.ArrayList;
import java.util.List;


public class CalibrationTestList {

    private List<CalibrationTest> calibrationTests = new ArrayList<>();

    public CalibrationTestList(List<CalibrationTest> list) {
        this.calibrationTests = list;
    }

    public List<CalibrationTest> getCalibrationTests() {
        return calibrationTests;
    }

    public void setCalibrationTests(List<CalibrationTest> calibrationTests) {
        this.calibrationTests = calibrationTests;
    }
}