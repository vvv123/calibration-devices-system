package com.softserve.edu.service;


import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.CalibrationTestData;
import com.softserve.edu.repository.CalibrationTestDataRepository;
import com.softserve.edu.repository.CalibrationTestRepository;
import com.softserve.edu.service.exceptions.CalibrationTestNotFoundException;
import com.softserve.edu.service.utils.CalibrationTestDataList;
import com.softserve.edu.service.utils.CalibrationTestList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CalibrationTestService {

    @Autowired
    private CalibrationTestRepository testRepository;

    @Autowired
    private CalibrationTestDataRepository dataRepository;

    public CalibrationTest deleteTest(Long id){
        CalibrationTest deletedCalibrationTest = testRepository.findOne(id);
        testRepository.delete(id);
        return deletedCalibrationTest;
    }

    public CalibrationTest findTest(Long id){
        return testRepository.findOne(id);
    }

    public CalibrationTest updateTest(Long id, CalibrationTest data){
        CalibrationTest updatedCalibrationTest = testRepository.findOne(id);
        updatedCalibrationTest.setName(data.getName());
        updatedCalibrationTest.setDateTest(data.getDateTest());
        updatedCalibrationTest.setTemperature(data.getTemperature());
        updatedCalibrationTest.setSettingNumber(data.getSettingNumber());
        updatedCalibrationTest.setLatitude(data.getLatitude());
        updatedCalibrationTest.setLongitude(data.getLongitude());
        updatedCalibrationTest.setConsumptionStatus(data.getConsumptionStatus());
        updatedCalibrationTest.setTestResult(data.getTestResult());
        updatedCalibrationTest = testRepository.save(updatedCalibrationTest);
        return updatedCalibrationTest;
    }

    public CalibrationTest createTest(CalibrationTest data){
        return testRepository.save(data);
    }

    public CalibrationTestList findAllCalibrationTests (){
        List<CalibrationTest> list = (ArrayList<CalibrationTest>) testRepository.findAll();
        CalibrationTestList foundTests = new CalibrationTestList(list);
        return foundTests;
    }

    public CalibrationTestData createTestData(Long testId, CalibrationTestData data) {
        CalibrationTest calibrationTest = testRepository.findOne(testId);
        if(calibrationTest == null) {
            throw new CalibrationTestNotFoundException();
        }
        CalibrationTestData testData = dataRepository.save(data);
        testData.setCalibrationTest(calibrationTest);
        return testData;
    }

    public CalibrationTestDataList findAllTestDataAsociatedWithTest(
            Long calibrationTestId){
        CalibrationTest calibrationTest = testRepository.findOne(calibrationTestId);
        if (calibrationTest == null){
            throw new CalibrationTestNotFoundException();
        }else{
            return new CalibrationTestDataList(calibrationTestId
                    , dataRepository.findByCalibrationTestId(calibrationTestId));
        }
    }
}