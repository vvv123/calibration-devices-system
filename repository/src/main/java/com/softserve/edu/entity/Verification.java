package com.softserve.edu.entity;


import com.softserve.edu.entity.user.ProviderEmployee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Verification {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deviceId")
    private Device device;

    @OneToMany
    @JoinColumn(name = "verification_id")
    private Set<CalibrationTest> calibrationTests;


    @ManyToOne
    private Provider provider;

    @ManyToOne
    private ProviderEmployee providerEmployee;

    //others...



}
