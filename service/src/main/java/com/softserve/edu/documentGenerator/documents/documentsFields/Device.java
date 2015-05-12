package com.softserve.edu.documentGenerator.documents.documentsFields;

/**
 * Created by oleg on 5/11/15.
 */
public class Device {
    private String deviceName;
    private String deviceConditionalSign;
    private Integer serialNumber;
    private String manufacturer;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceConditionalSign() {
        return deviceConditionalSign;
    }

    public void setDeviceConditionalSign(String deviceConditionalSign) {
        this.deviceConditionalSign = deviceConditionalSign;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
