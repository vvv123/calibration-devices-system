package com.softserve.edu.entity;

import com.softserve.edu.entity.util.DeviceType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="`DEVICE`")
public class Device {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    //@Column(nullable = false)
    private String deviceSign;

    @Column(nullable = false)
    private String number;

    @OneToMany(mappedBy = "device")
    private Set<Verification> verifications;
    
    @ManyToOne
    private Provider provider;

    @ManyToOne
    private Manufacturer manufacturer;

    public Device() {
    }

    public Device(String number, Set<Verification> verifications, Manufacturer manufacturer) {
        this.number = number;
        this.verifications = verifications;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceSign() {
        return deviceSign;
    }

    public void setDeviceSign(String deviceSign) {
        this.deviceSign = deviceSign;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Verification> getVerifications() {
        return verifications;
    }

    public void setVerifications(Set<Verification> verifications) {
        this.verifications = verifications;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
