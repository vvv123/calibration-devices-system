package com.softserve.edu.controller;

import com.softserve.edu.entity.CalibrationTest;

import com.softserve.edu.resources.CalibrationTestResource;
import com.softserve.edu.resources.asm.CalibrationTestResourceAsm;
import com.softserve.edu.service.CalibrationTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calibrationTest")
public class CalibrationTestController {

    private CalibrationTestService service;

    public CalibrationTestController (CalibrationTestService service){
        this.service = service;
    }
    @RequestMapping(value = "/{calibrationTestId}", method = RequestMethod.GET)
    public ResponseEntity<CalibrationTestResource> getCalibrationTest(
            @PathVariable Long calibrationTestId){
        CalibrationTest calibrationTest = service.findOne(calibrationTestId);
        if(calibrationTest != null) {
            CalibrationTestResource resource = new CalibrationTestResourceAsm()
                    .toResource(calibrationTest);
            return new ResponseEntity<CalibrationTestResource>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<CalibrationTestResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{calibrationTestId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<CalibrationTestResource> deleteCalibrationTest(
            @PathVariable Long calibrationTestId) {
        CalibrationTest calibrationTest = service.deleteTest(calibrationTestId);
        if(calibrationTest != null) {
            CalibrationTestResource resource = new CalibrationTestResourceAsm()
                    .toResource(calibrationTest);
            return new ResponseEntity<CalibrationTestResource>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<CalibrationTestResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{calibrationTestId}",
            method = RequestMethod.PUT)
    public ResponseEntity<CalibrationTestResource> updateCalibrationTest(
            @PathVariable Long calibrationTestId, @RequestBody CalibrationTestResource sentCalibrationTest) {
        CalibrationTest updatedCalibrationTest = service.updateCalibrationTest(calibrationTestId, sentCalibrationTest.toCalibrationTest());
;
        if(updatedCalibrationTest != null)
        {
            CalibrationTestResource resource = new CalibrationTestResourceAsm()
                    .toResource(updatedCalibrationTest);
            return new ResponseEntity<CalibrationTestResource>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<CalibrationTestResource>(HttpStatus.NOT_FOUND);
        }
    }
}