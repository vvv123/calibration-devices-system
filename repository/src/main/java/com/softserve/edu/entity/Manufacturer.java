package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(nullable = false)
    private String number;

    @OneToMany
    @JoinColumn(name = "manufacturer_id")
    private Set<Device> devices;

    protected Manufacturer() {
    }

    public Manufacturer(String name, String number, Set<Device> devices) {
        this.name = name;
        this.number = number;
        this.devices = devices;
    }

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }
}
