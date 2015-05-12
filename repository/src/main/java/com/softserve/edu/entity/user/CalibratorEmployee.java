package com.softserve.edu.entity.user;


import com.softserve.edu.entity.Organization;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CALIBRATOR_EMPLOYEE")
public class CalibratorEmployee extends Employee {

    public enum CalibratorEmployeeRole implements Role {
        CALIBRATOR_EMPLOYEE, CALIBRATOR_ADMIN;

        @Override
        public String roleName() {
            return name();
        }
    }

    public CalibratorEmployee() {}

    public CalibratorEmployee(String username, String password, Role role, Organization organization) {
        super(username, password, role, organization);
    }

    public CalibratorEmployee(String username, String password, Role role, Organization organization,
                              String firstName, String lastName, String email, String phone) {
        super(username, password, role, organization, firstName, lastName, email, phone);
    }
}
