package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class CalibrationTest {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateTest;
    private Integer temperature;
    private Integer settingNumber;
    private Double latitude;
    private Double longitude;
    private String consumptionStatus;
    private String testResult;
    private String photoPath;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "document_name")),
            @AttributeOverride(name = "sign", column = @Column(name = "document_sign"))
    })
    private MetrologicalDocument metrologicalDocument;

    @ManyToOne
    private Verification verification;

    @OneToMany(mappedBy = "calibrationTest")
    private Set<CalibrationTestData> calibrationTestDatas;

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

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
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

    public String getConsumptionStatus() {
        return consumptionStatus;
    }

    public void setConsumptionStatus(String consumptionStatus) {
        this.consumptionStatus = consumptionStatus;
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

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public Set<CalibrationTestData> getCalibrationTestDatas() {
        return calibrationTestDatas;
    }

    public void setCalibrationTestDatas(Set<CalibrationTestData> calibrationTestDatas) {
        this.calibrationTestDatas = calibrationTestDatas;
    }

    public MetrologicalDocument getMetrologicalDocument() {
        return metrologicalDocument;
    }

    public void setMetrologicalDocument(MetrologicalDocument metrologicalDocument) {
        this.metrologicalDocument = metrologicalDocument;
    }
}