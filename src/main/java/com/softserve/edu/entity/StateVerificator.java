package com.softserve.edu.entity;

import com.softserve.edu.entity.user.StateVerificatorEmployee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class StateVerificator {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "stateVerificators")
    private Set<Calibrator> calibrators;

    @OneToMany(mappedBy = "stateVerificator")
    private Set<CalibrationTest> calibrationTests;

    @OneToMany
    @JoinColumn(name = "state_verificator_id")
    private Set<StateVerificatorEmployee> stateVerificatorEmployees;

    protected StateVerificator(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Calibrator> getCalibrators() {
        return calibrators;
    }

    public void setCalibrators(Set<Calibrator> calibrators) {
        this.calibrators = calibrators;
    }

    public Set<CalibrationTest> getCalibrationTests() {
        return calibrationTests;
    }

    public void setCalibrationTests(Set<CalibrationTest> calibrationTests) {
        this.calibrationTests = calibrationTests;
    }

    public Set<StateVerificatorEmployee> getStateVerificatorEmployees() {
        return stateVerificatorEmployees;
    }

    public void setStateVerificatorEmployees(Set<StateVerificatorEmployee> stateVerificatorEmployees) {
        this.stateVerificatorEmployees = stateVerificatorEmployees;
    }
}
