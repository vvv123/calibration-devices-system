package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToMany
    @JoinColumn(name = "manufacturer_id")
    private Set<Device> devices;

}
