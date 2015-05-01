package com.softserve.edu.app.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @Id @GeneratedValue
    Long id;

    @ManyToMany
    @JoinTable(name = "client_app",
            joinColumns = {@JoinColumn(nullable = false, name = "client_id")},
            inverseJoinColumns = {@JoinColumn(nullable = false, name = "app_id")})
    Set<Provider> providers;

    @OneToMany
    @JoinColumn(name="client_id")
    Set<ClientApplication> applications;
}
