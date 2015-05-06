package com.softserve.edu.entity;

import com.softserve.edu.entity.user.ProviderEmployee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Provider {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    @JoinTable(name = "Provider_Calibrator",
            joinColumns = {@JoinColumn(nullable = false, name = "provider_id")},
            inverseJoinColumns = {@JoinColumn(nullable = false, name = "calibrator_id")})
    private Set<Calibrator> calibrators;


    @OneToMany
    @JoinColumn(name = "provider_id")
    private Set<ProviderEmployee> providerEmployees;

    @OneToMany
    @JoinColumn(name = "provider_id")
    private Set<Verification> verificationSet;


}
