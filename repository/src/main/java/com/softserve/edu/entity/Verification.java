package com.softserve.edu.entity;


import com.softserve.edu.entity.user.ProviderEmployee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Verification {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deviceId")
    private Device device;

    @OneToMany
    @JoinColumn(name = "verification_id")
    private Set<CalibrationTest> calibrationTests;


    @ManyToOne
    private Provider provider;

    @ManyToOne
    private ProviderEmployee providerEmployee;


    @Embedded
    private Address clientAddress;

    @Embedded
    private ClientData clientData;

    //others...


    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Set<CalibrationTest> getCalibrationTests() {
        return calibrationTests;
    }

    public void setCalibrationTests(Set<CalibrationTest> calibrationTests) {
        this.calibrationTests = calibrationTests;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public ProviderEmployee getProviderEmployee() {
        return providerEmployee;
    }

    public void setProviderEmployee(ProviderEmployee providerEmployee) {
        this.providerEmployee = providerEmployee;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public void setClientData(ClientData clientData) {
        this.clientData = clientData;
    }
}
