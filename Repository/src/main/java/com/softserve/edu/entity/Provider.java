package com.softserve.edu.entity;

import com.softserve.edu.entity.user.Client;
import com.softserve.edu.entity.user.ProviderEmployee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Provider {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "providers")
    private Set<Client> clients;

    @ManyToMany
    @JoinTable(name = "provider_calibrator",
            joinColumns = {@JoinColumn(nullable = false, name = "provider_id")},
            inverseJoinColumns = {@JoinColumn(nullable = false, name = "calibrator_id")})
    private Set<Calibrator> calibrators;

    @OneToMany(mappedBy = "provider")
    private Set<ClientApplication> clientApplications;

    @OneToMany
    @JoinColumn(name = "provider_id")
    private Set<ProviderEmployee> providerEmployees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Calibrator> getCalibrators() {
        return calibrators;
    }

    public void setCalibrators(Set<Calibrator> calibrators) {
        this.calibrators = calibrators;
    }

    public Set<ClientApplication> getClientApplications() {
        return clientApplications;
    }

    public void setClientApplications(Set<ClientApplication> clientApplications) {
        this.clientApplications = clientApplications;
    }

    public Set<ProviderEmployee> getProviderEmployees() {
        return providerEmployees;
    }

    public void setProviderEmployees(Set<ProviderEmployee> providerEmployees) {
        this.providerEmployees = providerEmployees;
    }
}
