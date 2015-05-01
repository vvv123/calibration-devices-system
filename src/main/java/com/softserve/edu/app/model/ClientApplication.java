package com.softserve.edu.app.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClientApplication {
    @ManyToOne()
    @JoinColumn(name = "provider_id")
    Provider provider;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    Client client;
}
