package com.softserve.edu.service;


import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.CalibrationTestData;
import com.softserve.edu.repository.CalibrationTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CalibrationTestService {

    @Autowired
    private CalibrationTestRepository repository;

    public CalibrationTest deleteTest(Long id){
        CalibrationTest deletedCalibrationTest = repository.findOne(id);
        repository.delete(id);
        return deletedCalibrationTest;
    }

    public CalibrationTest findTest(Long id){
        CalibrationTest calibrationTest = repository.findOne(id);
        return calibrationTest;
    }

    public CalibrationTest updateTest(Long id, CalibrationTest calibrationTest){
        CalibrationTest updatedCalibrationTest = repository.findOne(id);
        updatedCalibrationTest = repository.save(calibrationTest);
        return updatedCalibrationTest;
    }

    public CalibrationTest createTest(CalibrationTest data){
        CalibrationTest createdCallibrationTest = repository.save(data);
        return createdCallibrationTest;
    }
}