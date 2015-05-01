package com.softserve.edu.app.model;

import javax.persistence.*;

@Entity
public class CalibrationTestData {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Float givenConsumption;

    @Column
    private Integer acceptableError;

    @Column
    private Integer volumeOfStdart;

    @Column
    private  Float initialValue;

    @Column
    private Float endValue;

    @Column
    private Float VolumInDevice;

    @Column
    private Float timeOfTest;

    @Column
    private Float actualConsumption;

    @Column
    private Float consumptionStatus;

    @ManyToOne
    @JoinColumn(name = "calibrationTest_id")
    private CalibrationTest calibrationTest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getGivenConsumption() {
        return givenConsumption;
    }

    public void setGivenConsumption(Float givenConsumption) {
        this.givenConsumption = givenConsumption;
    }

    public Integer getAcceptableError() {
        return acceptableError;
    }

    public void setAcceptableError(Integer acceptableError) {
        this.acceptableError = acceptableError;
    }

    public Integer getVolumeOfStdart() {
        return volumeOfStdart;
    }

    public void setVolumeOfStdart(Integer volumeOfStdart) {
        this.volumeOfStdart = volumeOfStdart;
    }

    public Float getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Float initialValue) {
        this.initialValue = initialValue;
    }

    public Float getEndValue() {
        return endValue;
    }

    public void setEndValue(Float endValue) {
        this.endValue = endValue;
    }

    public Float getVolumInDevice() {
        return VolumInDevice;
    }

    public void setVolumInDevice(Float volumInDevice) {
        VolumInDevice = volumInDevice;
    }

    public Float getTimeOfTest() {
        return timeOfTest;
    }

    public void setTimeOfTest(Float timeOfTest) {
        this.timeOfTest = timeOfTest;
    }

    public Float getActualConsumption() {
        return actualConsumption;
    }

    public void setActualConsumption(Float actualConsumption) {
        this.actualConsumption = actualConsumption;
    }

    public Float getConsumptionStatus() {
        return consumptionStatus;
    }

    public void setConsumptionStatus(Float consumptionStatus) {
        this.consumptionStatus = consumptionStatus;
    }

    public CalibrationTest getCalibrationTest() {
        return calibrationTest;
    }

    public void setCalibrationTest(CalibrationTest calibrationTest) {
        this.calibrationTest = calibrationTest;
    }
}
