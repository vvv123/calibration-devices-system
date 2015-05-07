package com.softserve.edu.entity;

import com.softserve.edu.entity.utils.DeviceType;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Device {

    @Id
    @GeneratedValue
    private Long id;

    private DeviceType deviceType;

    @Column(nullable = false)
    private String number;

    @OneToMany(mappedBy = "device")
    private Set<Verification> verifications;

    @ManyToOne
    private Manufacturer manufacturer;

    public Device(String number, Set<Verification> verifications, Manufacturer manufacturer) {
        this.number = number;
        this.verifications = verifications;
        this.manufacturer = manufacturer;
    }
}
