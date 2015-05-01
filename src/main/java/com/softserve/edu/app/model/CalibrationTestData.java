package com.softserve.edu.app.model;

import javax.persistence.*;

@Entity
public class CalibrationTestData {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "calibrationTest_id")
    private CalibrationTest calibrationTest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CalibrationTest getCalibrationTest() {
        return calibrationTest;
    }

    public void setCalibrationTest(CalibrationTest calibrationTest) {
        this.calibrationTest = calibrationTest;
    }
}
