package com.softserve.edu.app.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @ManyToMany
    @JoinTable(name = "client_provider",
            joinColumns = {@JoinColumn(nullable = false, name = "client_id")},
            inverseJoinColumns = {@JoinColumn(nullable = false, name = "provider_id")})
    Set<Provider> providers;

    @OneToMany(mappedBy = "client")
    Set<ClientApplication> applications;
}
