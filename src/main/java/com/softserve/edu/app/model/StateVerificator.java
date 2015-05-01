package com.softserve.edu.app.model;

import javax.persistence.*;
import java.util.Set;

//
@Entity
public class StateVerificator {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "stateVerificators")
    private Set<Calibrator> calibrators;

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
}
