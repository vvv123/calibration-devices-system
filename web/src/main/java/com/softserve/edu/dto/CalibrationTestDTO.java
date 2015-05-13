package com.softserve.edu.dto;

import com.softserve.edu.entity.CalibrationTest;
import org.springframework.hateoas.ResourceSupport;



public class CalibrationTestDTO extends ResourceSupport {
    private String name;
    private String deviceNumber;
    private Integer temperature;
    private Integer settingNumber;
    private Double latitude;
    private Double longitude;
    private String testResult;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getSettingNumber() {
        return settingNumber;
    }

    public void setSettingNumber(Integer settingNumber) {
        this.settingNumber = settingNumber;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public CalibrationTest toCalibrationTest() {
        CalibrationTest calibrationTest = new CalibrationTest();
        calibrationTest.setName(name);
        calibrationTest.setDeviceNumber(deviceNumber);
        calibrationTest.setTemperature(temperature);
        calibrationTest.setSettingNumber(settingNumber);
        calibrationTest.setLatitude(latitude);
        calibrationTest.setLongitude(longitude);
        calibrationTest.setTestResult(testResult);
        return calibrationTest;
    }
}
