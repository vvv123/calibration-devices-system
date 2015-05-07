package com.softserve.edu.entity;

import javax.persistence.*;

@Entity
public class CalibrationTestData {
    @Id
    @GeneratedValue
    private Long id;
    private Double givenConsumption;
    private Integer acceptableError;
    private Integer volumeOfStdart;
    private Double initialValue;
    private Double endValue;
    private Double volumInDevice;
    private Double testTime;
    private Double actualConsumption;
    private Double consumptionStatus;

    @ManyToOne
    @JoinColumn(name = "calibrationTest_id")
    private CalibrationTest calibrationTest;

}
