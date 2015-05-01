package com.softserve.edu.app.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @ManyToMany
    @JoinColumn(name="client_id")
    Set<Provider> providers;

    @OneToMany
    @JoinColumn(name="client_id")
    Set<ClientApplication> applications;
}
