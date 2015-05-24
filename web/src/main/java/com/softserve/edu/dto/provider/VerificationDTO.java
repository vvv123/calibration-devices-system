package com.softserve.edu.dto.provider;

import com.softserve.edu.dto.application.ClientStageVerificationDTO;
import com.softserve.edu.entity.Calibrator;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Provider;
import com.softserve.edu.entity.StateVerificator;
import com.softserve.edu.entity.user.CalibratorEmployee;
import com.softserve.edu.entity.user.ProviderEmployee;
import com.softserve.edu.entity.user.StateVerificatorEmployee;
import com.softserve.edu.entity.util.DeviceType;
import com.softserve.edu.entity.util.Status;

import java.util.Date;

public class VerificationDTO extends ClientStageVerificationDTO {

    private String id;
    private Date initialDate;
    private Date expirationDate;
    private Status status;
    private String calibrator;
    private String calibratorEmployee;
    private String device;
    private String provider;
    private String providerEmployee;
    private String stateVerificator;
    private String stateVerificatorEmployee;

    protected VerificationDTO() {}

    public VerificationDTO(
            ClientData clientData, String id, Date initialDate, Date expirationDate,
            Status status, Calibrator calibrator, CalibratorEmployee calibratorEmployee,
            DeviceType device, Provider provider, ProviderEmployee providerEmployee,
            StateVerificator stateVerificator, StateVerificatorEmployee stateVerificatorEmployee) {

        super(clientData, clientData.getClientAddress(), null);
        this.id = id;
        this.initialDate = initialDate;
        this.expirationDate = expirationDate;
        this.status = status;
        this.calibrator = calibrator.getName();
        this.calibratorEmployee = calibratorEmployee.getFirstName() + " " + calibratorEmployee.getLastName();
        this.device = device.name();
        this.provider = provider.getName();
        this.providerEmployee = providerEmployee.getFirstName() + " " + providerEmployee.getLastName();
        this.stateVerificator = stateVerificator.getName();
        this.stateVerificatorEmployee = stateVerificatorEmployee.getFirstName() + " " + stateVerificatorEmployee.getLastName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCalibrator() {
        return calibrator;
    }

    public void setCalibrator(String calibrator) {
        this.calibrator = calibrator;
    }

    public String getCalibratorEmployee() {
        return calibratorEmployee;
    }

    public void setCalibratorEmployee(String calibratorEmployee) {
        this.calibratorEmployee = calibratorEmployee;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderEmployee() {
        return providerEmployee;
    }

    public void setProviderEmployee(String providerEmployee) {
        this.providerEmployee = providerEmployee;
    }

    public String getStateVerificator() {
        return stateVerificator;
    }

    public void setStateVerificator(String stateVerificator) {
        this.stateVerificator = stateVerificator;
    }

    public String getStateVerificatorEmployee() {
        return stateVerificatorEmployee;
    }

    public void setStateVerificatorEmployee(String stateVerificatorEmployee) {
        this.stateVerificatorEmployee = stateVerificatorEmployee;
    }
}
