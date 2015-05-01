package com.softserve.edu.app.model;

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
}
