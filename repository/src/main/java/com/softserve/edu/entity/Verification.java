package com.softserve.edu.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Verification {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @OneToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @OneToMany
    @JoinColumn(name = "verification_id")
    private Set<CalibrationTest> calibrationTests;

    @ManyToOne
    private Provider provider;

    @ManyToOne
    private Calibrator calibrator;

    @ManyToOne
    private StateVerificator stateVerificator;

}
