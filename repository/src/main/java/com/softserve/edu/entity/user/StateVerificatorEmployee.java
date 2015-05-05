package com.softserve.edu.entity.user;

import com.softserve.edu.entity.StateVerificator;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class StateVerificatorEmployee extends User {

    @ManyToOne
    private StateVerificator stateVerificator;

    protected StateVerificatorEmployee() {}

    public StateVerificatorEmployee(String email, String password,
                                    String name, String surname, String middleName) {
        super(email, password, Role.STATE_VERIFICATOR_EMPLOYEE, name, surname, middleName);
    }

    public StateVerificator getStateVerificator() {
        return stateVerificator;
    }

    public void setStateVerificator(StateVerificator stateVerificator) {
        this.stateVerificator = stateVerificator;
    }
}
