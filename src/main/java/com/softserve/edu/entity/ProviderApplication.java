package com.softserve.edu.entity;

import javax.persistence.*;

@Entity
public class ProviderApplication {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "calibrator_id")
    private Calibrator calibrator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Calibrator getCalibrator() {
        return calibrator;
    }

    public void setCalibrator(Calibrator calibrator) {
        this.calibrator = calibrator;
    }
}
