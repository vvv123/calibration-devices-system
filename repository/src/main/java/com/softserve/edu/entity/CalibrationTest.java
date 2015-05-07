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

    @ManyToOne
    private Verification verification;

    @OneToMany(mappedBy = "calibrationTest")
    private Set<CalibrationTestData> calibrationTestDatas;

}
