package com.softserve.edu.dto.asm;

import com.softserve.edu.controller.CalibrationTestController;
import com.softserve.edu.controller.CalibrationTestDataController;
import com.softserve.edu.dto.CalibrationTestDataDTO;
import com.softserve.edu.entity.CalibrationTestData;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


public class CalibrationTestDataDTOAsm
        extends ResourceAssemblerSupport<CalibrationTestData, CalibrationTestDataDTO> {
    public CalibrationTestDataDTOAsm(){
        super(CalibrationTestDataController.class, CalibrationTestDataDTO.class);
    }

    @Override
    public CalibrationTestDataDTO toResource(CalibrationTestData calibrationTestData) {
        CalibrationTestDataDTO resource = new CalibrationTestDataDTO();
        resource.setGivenConsumption(calibrationTestData.getGivenConsumption());
        resource.setAcceptableError(calibrationTestData.getAcceptableError());
        resource.setVolumeOfStandart(calibrationTestData.getVolumeOfStandart());
        resource.setInitialValue(calibrationTestData.getInitialValue());
        resource.setEndValue(calibrationTestData.getEndValue());
        resource.setVolumeInDevice(calibrationTestData.getVolumeInDevice());
        resource.setTestTime(calibrationTestData.getTestTime());
        resource.setActualConsumption(calibrationTestData.getActualConsumption());
        resource.setConsumptionStatus(calibrationTestData.getConsumptionStatus());
        resource.setCalculationError(calibrationTestData.getCalculationError());
        resource.setTestResult(calibrationTestData.getTestResult());
        Link self = linkTo(CalibrationTestDataController.class)
                .slash(calibrationTestData.getId()).withSelfRel();
        resource.add(self);
        if(calibrationTestData.getCalibrationTest() != null){
            resource.add((linkTo(CalibrationTestController.class)
                    .slash(calibrationTestData.getCalibrationTest().getId())
                    .withRel("owner")));
        }
        return resource;
    }
}
