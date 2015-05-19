package com.softserve.edu.entity;

import com.softserve.edu.entity.user.CalibratorEmployee;
import com.softserve.edu.entity.user.ProviderEmployee;
import com.softserve.edu.entity.user.StateVerificatorEmployee;
import com.softserve.edu.entity.util.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * Verification entity.
 * Contains data about whole business process of verification.
 */
@Entity
@Table(name = "`VERIFICATION`")
public class Verification {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * Date when the verification was finished
     */
    @Temporal(TemporalType.DATE)
    private Date verificationFinishedDate;

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

    @ManyToOne
    private Calibrator calibrator;
    @ManyToOne
    private CalibratorEmployee calibratorEmployee;

    @ManyToOne
    private StateVerificator stateVerificator;
    @ManyToOne
    private StateVerificatorEmployee stateVerificatorEmployee;

    @Embedded
    private ClientData clientData;

    protected Verification() {}

    public Verification(ClientData clientData, Status status) {
        this.id = UUID.randomUUID().toString();
        this.clientData = clientData;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

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

    public Calibrator getCalibrator() {
        return calibrator;
    }

    public void setCalibrator(Calibrator calibrator) {
        this.calibrator = calibrator;
    }

    public CalibratorEmployee getCalibratorEmployee() {
        return calibratorEmployee;
    }

    public void setCalibratorEmployee(CalibratorEmployee calibratorEmployee) {
        this.calibratorEmployee = calibratorEmployee;
    }

    public StateVerificator getStateVerificator() {
        return stateVerificator;
    }

    public void setStateVerificator(StateVerificator stateVerificator) {
        this.stateVerificator = stateVerificator;
    }

    public StateVerificatorEmployee getStateVerificatorEmployee() {
        return stateVerificatorEmployee;
    }

    public void setStateVerificatorEmployee(StateVerificatorEmployee stateVerificatorEmployee) {
        this.stateVerificatorEmployee = stateVerificatorEmployee;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public void setClientData(ClientData clientData) {
        this.clientData = clientData;
    }

    public Date getVerificationFinishedDate() {
        return verificationFinishedDate;
    }

    public void setVerificationFinishedDate(Date verificationFinishedDate) {
        this.verificationFinishedDate = verificationFinishedDate;
    }
}
