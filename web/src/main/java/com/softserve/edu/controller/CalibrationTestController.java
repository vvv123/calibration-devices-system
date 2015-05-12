package com.softserve.edu.controller;

import com.softserve.edu.exceptions.NotFoundException;
import com.softserve.edu.dto.CalibrationTestDataDTO;
import com.softserve.edu.dto.CalibrationTestDataListDTO;
import com.softserve.edu.dto.asm.CalibrationTestDataDTOAsm;
import com.softserve.edu.dto.asm.CalibrationTestDataListDTOAsm;
import com.softserve.edu.entity.CalibrationTest;

import com.softserve.edu.dto.CalibrationTestListDTO;
import com.softserve.edu.dto.CalibrationTestDTO;
import com.softserve.edu.dto.asm.CalibrationTestListDTOAsm;
import com.softserve.edu.dto.asm.CalibrationTestDTOAsm;
import com.softserve.edu.entity.CalibrationTestData;
import com.softserve.edu.service.CalibrationTestService;
import com.softserve.edu.service.exceptions.CalibrationTestNotFoundException;
import com.softserve.edu.service.utils.CalibrationTestDataList;
import com.softserve.edu.service.utils.CalibrationTestList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/calibrationTests")
public class CalibrationTestController {

    @Autowired
    private CalibrationTestService service;


    @RequestMapping(value = "/{calibrationTestId}", method = RequestMethod.GET)
    public ResponseEntity<CalibrationTestDTO> getCalibrationTest(
            @PathVariable Long calibrationTestId){
        CalibrationTest calibrationTest = service.findTest(calibrationTestId);
        if(calibrationTest != null) {
            CalibrationTestDTO resource = new CalibrationTestDTOAsm()
                    .toResource(calibrationTest);
            return new ResponseEntity<>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{calibrationTestId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<CalibrationTestDTO> deleteCalibrationTest(
            @PathVariable Long calibrationTestId) {
        CalibrationTest calibrationTest = service.deleteTest(calibrationTestId);
        if(calibrationTest != null) {
            CalibrationTestDTO resource = new CalibrationTestDTOAsm()
                    .toResource(calibrationTest);
            return new ResponseEntity<>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{calibrationTestId}",
            method = RequestMethod.PUT)
    public ResponseEntity<CalibrationTestDTO> updateCalibrationTest(
            @PathVariable Long calibrationTestId, @RequestBody CalibrationTestDTO sentCalibrationTest) {
        CalibrationTest updatedCalibrationTest = service.updateTest(calibrationTestId, sentCalibrationTest.toCalibrationTest());
        if(updatedCalibrationTest != null)
        {
            CalibrationTestDTO resource = new CalibrationTestDTOAsm()
                    .toResource(updatedCalibrationTest);
            return new ResponseEntity<>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CalibrationTestDTO> createCalibrationTest(
            @RequestBody CalibrationTestDTO sentTest) {
        CalibrationTest createdCalibrationTest = service.createTest(sentTest.toCalibrationTest());
        CalibrationTestDTO res = new CalibrationTestDTOAsm().toResource(createdCalibrationTest);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(res.getLink("self").getHref()));
        return new ResponseEntity<>(res, headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<CalibrationTestListDTO> findAllCalibrationTests() {
        CalibrationTestList list = service.findAllCalibrationTests();
        CalibrationTestListDTO res =  new CalibrationTestListDTOAsm().toResource(list);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value="/{calibrationTestId}/testData",
            method = RequestMethod.POST)
    public ResponseEntity<CalibrationTestDataDTO> createTestData(
            @PathVariable Long calibrationTestId,
            @RequestBody CalibrationTestDataDTO sentTestData) {
        CalibrationTestData createdTestData;
        try {
            createdTestData = service.createTestData(calibrationTestId, sentTestData.toTestData());
            CalibrationTestDataDTO createdTestDataDTO =
                    new CalibrationTestDataDTOAsm().toResource(createdTestData);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdTestDataDTO.getLink("self").getHref()));
            return new ResponseEntity<>(createdTestDataDTO, headers, HttpStatus.CREATED);
        } catch (CalibrationTestNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @RequestMapping(value="/{calibrationTestId}/testData")
    public ResponseEntity<CalibrationTestDataListDTO> findAllCalibrationTestData(
            @PathVariable Long calibrationTestId)
    {
        try {
            CalibrationTestDataList list = service.findAllTestDataAsociatedWithTest(calibrationTestId);
            CalibrationTestDataListDTO res = new CalibrationTestDataListDTOAsm().toResource(list);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch(CalibrationTestNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }
}