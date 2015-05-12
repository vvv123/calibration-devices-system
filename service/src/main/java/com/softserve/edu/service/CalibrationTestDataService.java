package com.softserve.edu.service;

import com.softserve.edu.entity.CalibrationTestData;
import com.softserve.edu.repository.CalibrationTestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CalibrationTestDataService {

    @Autowired
    private CalibrationTestDataRepository dataRepository;

    public CalibrationTestData findTestData(Long id){
        return dataRepository.findOne(id);
    }

    public CalibrationTestData deleteTestData(Long id){
        CalibrationTestData deletedTestData = dataRepository.findOne(id);
        dataRepository.delete(id);
        return deletedTestData;
    }

    public CalibrationTestData updateTestData(Long id, CalibrationTestData testData){
        CalibrationTestData updatedCalibrationTestData = dataRepository.findOne(id);
        updatedCalibrationTestData.setActualConsumption(testData.getActualConsumption());
        updatedCalibrationTestData = dataRepository.save(updatedCalibrationTestData);
        return updatedCalibrationTestData;
    }
}