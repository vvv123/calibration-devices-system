package com.softserve.edu.dto.asm;

import com.softserve.edu.controller.CalibrationTestController;
import com.softserve.edu.dto.CalibrationTestDataDTO;
import com.softserve.edu.dto.CalibrationTestDataListDTO;
import com.softserve.edu.service.utils.CalibrationTestDataList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class CalibrationTestDataListDTOAsm
        extends ResourceAssemblerSupport<CalibrationTestDataList, CalibrationTestDataListDTO> {
    public CalibrationTestDataListDTOAsm() {
        super(CalibrationTestController.class, CalibrationTestDataListDTO.class);
    }

    @Override
    public CalibrationTestDataListDTO toResource(CalibrationTestDataList list) {
        List<CalibrationTestDataDTO> resources = new CalibrationTestDataDTOAsm().toResources(list.getListTestData());
        CalibrationTestDataListDTO listResource = new CalibrationTestDataListDTO();
        listResource.setListTestData(resources);
        listResource.add(linkTo(methodOn(CalibrationTestController.class).findAllCalibrationTestData(list.getTestId())).withSelfRel());
        return listResource;
    }
}