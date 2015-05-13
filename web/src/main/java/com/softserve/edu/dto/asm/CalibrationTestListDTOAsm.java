package com.softserve.edu.dto.asm;

import com.softserve.edu.controller.CalibrationTestController;
import com.softserve.edu.dto.CalibrationTestListDTO;
import com.softserve.edu.dto.CalibrationTestDTO;
import com.softserve.edu.service.utils.CalibrationTestList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;


public class CalibrationTestListDTOAsm extends ResourceAssemblerSupport<CalibrationTestList,
        CalibrationTestListDTO> {
    public CalibrationTestListDTOAsm() {
        super(CalibrationTestController.class,
                CalibrationTestListDTO.class);
    }

    @Override
    public CalibrationTestListDTO toResource(CalibrationTestList calibrationTestList) {
        List<CalibrationTestDTO> resList = new CalibrationTestDTOAsm()
                .toResources(calibrationTestList.getCalibrationTests());
        CalibrationTestListDTO finalRes = new CalibrationTestListDTO();
        finalRes.setCalibrationTests(resList);
        return finalRes;
    }
}

