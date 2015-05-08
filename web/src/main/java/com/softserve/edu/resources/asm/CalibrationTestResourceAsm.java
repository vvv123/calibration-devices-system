package com.softserve.edu.resources.asm;
/*
import com.softserve.edu.controller.CalibrationTestController;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.resources.CalibrationTestResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class CalibrationTestResourceAsm extends ResourceAssemblerSupport<CalibrationTest, CalibrationTestResource>{
    public CalibrationTestResourceAsm(){
        super(CalibrationTestController.class, CalibrationTestResource.class);
    }

    @Override
    public CalibrationTestResource toResource(CalibrationTest calibrationTest) {
        CalibrationTestResource res = new CalibrationTestResource();
        res.setName(calibrationTest.getName());
        Link link = linkTo(methodOn(CalibrationTestController.class).getCalibrationTest(
                calibrationTest.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}*/