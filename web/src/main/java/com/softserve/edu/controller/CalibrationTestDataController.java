package com.softserve.edu.controller;


import com.softserve.edu.dto.CalibrationTestDataDTO;
import com.softserve.edu.dto.asm.CalibrationTestDataDTOAsm;
import com.softserve.edu.entity.CalibrationTestData;
import com.softserve.edu.service.CalibrationTestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/calibrationTestData")
public class CalibrationTestDataController {

    @Autowired
    private CalibrationTestDataService service;

    @RequestMapping(value = "/{testDataId}", method = RequestMethod.GET)
    public ResponseEntity<CalibrationTestDataDTO> getTestData(
            @PathVariable Long testDataId) {
        CalibrationTestData testData = service.findTestData(testDataId);
        if (testData != null){
            CalibrationTestDataDTO resource = new CalibrationTestDataDTOAsm()
                    .toResource(testData);
            return new ResponseEntity<>(resource, HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{testDataId}", method = RequestMethod.DELETE)
    public ResponseEntity<CalibrationTestDataDTO> deleteTestData(
            @PathVariable Long testDataId){
        CalibrationTestData testData = service.deleteTestData(testDataId);
        if(testData != null){
            CalibrationTestDataDTO res = new CalibrationTestDataDTOAsm().toResource(testData);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{testDataId}", method = RequestMethod.PUT)
    public ResponseEntity<CalibrationTestDataDTO> updateTestData(
            @PathVariable Long testDataId, @RequestBody CalibrationTestDataDTO sentTestData){
        CalibrationTestData updatedTestData = service.updateTestData(testDataId,
                sentTestData.toTestData());
        if(updatedTestData != null){
            CalibrationTestDataDTO res = new CalibrationTestDataDTOAsm()
                    .toResource(updatedTestData);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
