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

    @OneToMany
    @JoinColumn(name = "stateVerificator_id")
    private Set<StateVerificatorEmployee> stateVerificatorEmployees;

    @OneToMany
    @JoinColumn(name = "stateVerificator_id")
    private Set<Verification> verifications;

    protected StateVerificator(){}

}
