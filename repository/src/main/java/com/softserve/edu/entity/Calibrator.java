package com.softserve.edu.entity;

import com.softserve.edu.entity.user.CalibratorEmployee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Calibrator {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "calibrators")
    private Set<Provider> providers;

    @ManyToMany
    @JoinTable(name = "Calibrator_StateVerificator",
            joinColumns = {@JoinColumn(nullable = false, name = "calibrator_id")},
            inverseJoinColumns = {@JoinColumn(nullable = false, name = "stateVerificator_id")})
    private Set<StateVerificator> stateVerificators;

    @OneToMany
    @JoinColumn(name = "calibrator_id")
    private Set<CalibratorEmployee> calibratorEmployees;

    @OneToMany
    @JoinColumn(name = "calibrator_id")
    private Set<Verification> verifications;

}
