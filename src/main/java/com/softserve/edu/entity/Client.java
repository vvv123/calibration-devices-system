package com.softserve.edu.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "client_provider",
            joinColumns = {@JoinColumn(nullable = false, name = "client_id")},
            inverseJoinColumns = {@JoinColumn(nullable = false, name = "provider_id")})
    private Set<Provider> providers;

    @OneToMany(mappedBy = "client")
    private Set<ClientApplication> applications;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
