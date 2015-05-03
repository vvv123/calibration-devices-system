package com.softserve.edu.entity;

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
    @JoinTable(name = "calibrator_stateVerificator",
            joinColumns = {@JoinColumn(nullable = false, name = "calibrator_id")},
            inverseJoinColumns = {@JoinColumn(nullable = false, name = "stateVerificator_id")})
    private Set<StateVerificator> stateVerificators;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Provider> getProviders() {
        return providers;
    }

    public void setProviders(Set<Provider> providers) {
        this.providers = providers;
    }

    public Set<StateVerificator> getStateVerificators() {
        return stateVerificators;
    }

    public void setStateVerificators(Set<StateVerificator> stateVerificators) {
        this.stateVerificators = stateVerificators;
    }
}
