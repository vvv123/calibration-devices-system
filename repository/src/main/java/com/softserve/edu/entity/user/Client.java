package com.softserve.edu.entity.user;


import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.ClientApplication;
import com.softserve.edu.entity.Provider;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client extends User {

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(name = "client_provider",
            joinColumns = {@JoinColumn(nullable = false, name = "client_id")},
            inverseJoinColumns = {@JoinColumn(nullable = false, name = "provider_id")})
    private Set<Provider> providers;

    @OneToMany(mappedBy = "client")
    private Set<ClientApplication> applications;

    protected Client() {}

    public Client(String email, String password, String name, String surname,
                  String middleName, Address address) {
        super(email, password, Role.CLIENT, name, surname, middleName);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Provider> getProviders() {
        return providers;
    }

    public void setProviders(Set<Provider> providers) {
        this.providers = providers;
    }

    public Set<ClientApplication> getApplications() {
        return applications;
    }

    public void setApplications(Set<ClientApplication> applications) {
        this.applications = applications;
    }
}
