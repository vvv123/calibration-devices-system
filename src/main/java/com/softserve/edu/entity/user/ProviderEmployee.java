package com.softserve.edu.entity.user;

import com.softserve.edu.entity.Provider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ProviderEmployee extends User {

    @ManyToOne
    private Provider provider;

    protected ProviderEmployee() {}

    public ProviderEmployee(String email, String password, String name,
                            String surname, String middleName, Provider provider) {
        super(email, password, Role.PROVIDER_EMPLOYEE, name, surname, middleName);
        this.provider = provider;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
