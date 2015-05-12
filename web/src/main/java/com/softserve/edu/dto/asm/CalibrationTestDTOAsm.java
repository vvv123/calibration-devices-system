package com.softserve.edu.dto.asm;

import com.softserve.edu.controller.CalibrationTestController;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.dto.CalibrationTestDTO;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class CalibrationTestDTOAsm extends ResourceAssemblerSupport<CalibrationTest, CalibrationTestDTO>{
    public CalibrationTestDTOAsm(){
        super(CalibrationTestController.class, CalibrationTestDTO.class);
    }



    @Override
    public CalibrationTestDTO toResource(CalibrationTest calibrationTest) {
        CalibrationTestDTO resource = new CalibrationTestDTO();
        resource.setName(calibrationTest.getName());
        resource.add(linkTo(CalibrationTestController.class).slash(calibrationTest.getId()).withSelfRel());
        resource.add(linkTo(CalibrationTestController.class).slash(calibrationTest.getId()).slash("testData").withRel("testData"));
        return resource;
    }

}