package com.softserve.edu.app.model;

import javax.persistence.*;

@Entity
public class ClientApplication {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    Provider provider;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;
}
