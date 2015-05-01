package com.softserve.edu.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CalibrationTest {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "calibrationTest")
    private Set<CalibrationTestData> calibrationTestDatas;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CalibrationTestData> getCalibrationTestDatas() {
        return calibrationTestDatas;
    }

    public void setCalibrationTestDatas(Set<CalibrationTestData> calibrationTestDatas) {
        this.calibrationTestDatas = calibrationTestDatas;
    }
}
