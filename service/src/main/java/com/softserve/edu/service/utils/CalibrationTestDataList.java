package com.softserve.edu.service.utils;

import com.softserve.edu.entity.CalibrationTestData;

import java.util.ArrayList;
import java.util.List;



public class CalibrationTestDataList {
    private List<CalibrationTestData> listTestData = new ArrayList<CalibrationTestData>();
    private Long testId;

    public CalibrationTestDataList (Long testId, List<CalibrationTestData> listTestData) {
        this.testId = testId;
        this.listTestData = listTestData;
    }

    public List<CalibrationTestData> getListTestData() {
        return listTestData;
    }

    public void setListTestData(List<CalibrationTestData> listTestData) {
        this.listTestData = listTestData;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

}