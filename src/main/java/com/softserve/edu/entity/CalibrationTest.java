package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class CalibrationTest {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String device_number;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_test")
    private Date dateOfTest;

    @Column
    private Integer temperature;

    @Column
    private Integer settingNumber;

    @Column
    private Float latitude;

    @Column
    private Float longitude;

    @Column
    private String consumeStatus;

    @Column
    private  String  testResult;

    @Column
    private String photoPath;



    @OneToMany(mappedBy = "calibrationTest")
    private Set<CalibrationTestData> calibrationTestDatas;

    @ManyToOne
    @JoinColumn(name = "calibrator_id")
    private Calibrator calibrator;

    @ManyToOne
    @JoinColumn(name = "stateVerificator_id")
    private StateVerificator stateVerificator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevice_number() {
        return device_number;
    }

    public void setDevice_number(String device_number) {
        this.device_number = device_number;
    }

    public Date getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Date dateOfTest) {
        this.dateOfTest = dateOfTest;
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

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getConsumeStatus() {
        return consumeStatus;
    }

    public void setConsumeStatus(String consumeStatus) {
        this.consumeStatus = consumeStatus;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Set<CalibrationTestData> getCalibrationTestDatas() {
        return calibrationTestDatas;
    }

    public void setCalibrationTestDatas(Set<CalibrationTestData> calibrationTestDatas) {
        this.calibrationTestDatas = calibrationTestDatas;
    }

    public Calibrator getCalibrator() {
        return calibrator;
    }

    public void setCalibrator(Calibrator calibrator) {
        this.calibrator = calibrator;
    }

    public StateVerificator getStateVerificator() {
        return stateVerificator;
    }

    public void setStateVerificator(StateVerificator stateVerificator) {
        this.stateVerificator = stateVerificator;
    }
}
