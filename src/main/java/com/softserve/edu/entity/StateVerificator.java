package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Set;

//
@Entity
public class StateVerificator {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "stateVerificators")
    private Set<Calibrator> calibrators;

    @OneToMany(mappedBy = "stateVerificator")
    private Set<CalibrationTest> calibrationTests;

}
