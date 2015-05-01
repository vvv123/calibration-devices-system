package com.softserve.edu.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Provider {
    @Id
    @GeneratedValue
    Long id;

    @ManyToMany(mappedBy = "providers")
    Set<Client> clients;

    @OneToMany(mappedBy = "provider")
    Set<ClientApplication> clientApplications;
}
