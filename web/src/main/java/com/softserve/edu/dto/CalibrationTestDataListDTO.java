package com.softserve.edu.dto;

import com.softserve.edu.dto.CalibrationTestDataDTO;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class CalibrationTestDataListDTO extends ResourceSupport {
    private List<CalibrationTestDataDTO> listTestData;

    public List<CalibrationTestDataDTO> getListTestData() {
        return listTestData;
    }

    public void setListTestData(List<CalibrationTestDataDTO> listTestData) {
        this.listTestData = listTestData;
    }
}