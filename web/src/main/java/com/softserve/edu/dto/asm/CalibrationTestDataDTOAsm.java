package com.softserve.edu.dto.asm;

import com.softserve.edu.controller.CalibrationTestController;
import com.softserve.edu.controller.CalibrationTestDataController;
import com.softserve.edu.dto.CalibrationTestDTO;
import com.softserve.edu.dto.CalibrationTestDataDTO;
import com.softserve.edu.entity.CalibrationTest;
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
        CalibrationTestDataDTO res = new CalibrationTestDataDTO();
        res.setActualConsumption(calibrationTestData.getActualConsumption());
        Link self = linkTo(CalibrationTestDataController.class)
                .slash(calibrationTestData.getId()).withSelfRel();
        res.add(self);
        if(calibrationTestData.getCalibrationTest() != null){
            res.add((linkTo(CalibrationTestController.class)
                    .slash(calibrationTestData.getCalibrationTest().getId())
                    .withRel("owner")));
        }
        return res;
    }


}