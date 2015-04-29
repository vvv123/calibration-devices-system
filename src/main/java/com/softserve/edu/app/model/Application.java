package com.softserve.edu.app.model;

import com.softserve.edu.app.model.utils.Device;

import javax.persistence.*;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Device device;
    private String description;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    protected Application() {}

    public Application(Device device, Client client) {
        this.device = device;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
