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

    @ManyToOne
    @JoinColumn(name = "calibrator_id")
    private Calibrator calibrator;

    @ManyToOne
    @JoinColumn(name = "stateVerificator_id")
    private StateVerificator stateVerificator;

}
