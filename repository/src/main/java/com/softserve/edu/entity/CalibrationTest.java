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
    private String deviceNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTest;
    private Integer temperature;
    private Integer settingNumber;
    private Double latitude;
    private Double longitude;
    private String consumptionStatus;
    private String testResult;
    private String photoPath;

    @OneToMany(mappedBy = "calibrationTest")
    private Set<CalibrationTestData> calibrationTestDatas;
    @ManyToOne

    @JoinColumn(name = "calibrator_id")
    private Calibrator calibrator;

    @ManyToOne
    @JoinColumn(name = "stateVerificator_id")
    private StateVerificator stateVerificator;


}
