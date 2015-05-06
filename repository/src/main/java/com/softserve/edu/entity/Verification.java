package com.softserve.edu.entity;


import javax.persistence.*;

@Entity
public class Verification {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @OneToOne(mappedBy = "verification")
    private Application application;

    @ManyToOne
    private Provider provider;

    @ManyToOne
    private Calibrator calibrator;

    @ManyToOne
    private StateVerificator stateVerificator;

}
