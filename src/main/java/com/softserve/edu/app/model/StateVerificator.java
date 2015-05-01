package com.softserve.edu.app.model;

import javax.persistence.*;
import java.util.List;
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
