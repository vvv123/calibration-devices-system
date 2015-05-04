package com.softserve.edu.entity.user;

import com.softserve.edu.entity.Calibrator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CalibratorEmployee extends User {

    @ManyToOne
    private Calibrator calibrator;

    protected CalibratorEmployee() {}

    public CalibratorEmployee(String email, String password,
                              String name, String surname, String middleName) {
        super(email, password, Role.CALIBRATOR_EMPLOYEE, name, surname, middleName);
    }

    public Calibrator getCalibrator() {
        return calibrator;
    }

    public void setCalibrator(Calibrator calibrator) {
        this.calibrator = calibrator;
    }
}
