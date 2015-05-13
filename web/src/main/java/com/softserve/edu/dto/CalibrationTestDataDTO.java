package com.softserve.edu.dto;

import com.softserve.edu.entity.CalibrationTestData;
import org.springframework.hateoas.ResourceSupport;


public class CalibrationTestDataDTO extends ResourceSupport {

    private double actualConsumption;
    private Double givenConsumption;
    private Integer volumeOfStandart;
    private Double initialValue;
    private Double endValue;
    private Double volumeInDevice;
    private Double testTime;
    private Double consumptionStatus;

    public double getActualConsumption() {
        return actualConsumption;
    }

    public void setActualConsumption(double actualConsumption) {
        this.actualConsumption = actualConsumption;
    }

    public Double getGivenConsumption() {
        return givenConsumption;
    }

    public void setGivenConsumption(Double givenConsumption) {
        this.givenConsumption = givenConsumption;
    }

    public Integer getVolumeOfStandart() {
        return volumeOfStandart;
    }

    public void setVolumeOfStandart(Integer volumeOfStandart) {
        this.volumeOfStandart = volumeOfStandart;
    }

    public Double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
    }

    public Double getEndValue() {
        return endValue;
    }

    public void setEndValue(Double endValue) {
        this.endValue = endValue;
    }

    public Double getVolumeInDevice() {
        return volumeInDevice;
    }

    public void setVolumeInDevice(Double volumeInDevice) {
        this.volumeInDevice = volumeInDevice;
    }

    public Double getTestTime() {
        return testTime;
    }

    public void setTestTime(Double testTime) {
        this.testTime = testTime;
    }

    public Double getConsumptionStatus() {
        return consumptionStatus;
    }

    public void setConsumptionStatus(Double consumptionStatus) {
        this.consumptionStatus = consumptionStatus;
    }

    public CalibrationTestData toTestData() {
        CalibrationTestData calibrationTestData = new CalibrationTestData();
        calibrationTestData.setActualConsumption(actualConsumption);
        calibrationTestData.setGivenConsumption(givenConsumption);
        calibrationTestData.setVolumeOfStandart(volumeOfStandart);
        calibrationTestData.setInitialValue(initialValue);
        calibrationTestData.setEndValue(endValue);
        calibrationTestData.setVolumeInDevice(volumeInDevice);
        calibrationTestData.setTestTime(testTime);
        calibrationTestData.setConsumptionStatus(consumptionStatus);

        return calibrationTestData;
    }

}
