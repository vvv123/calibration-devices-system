package com.softserve.edu.documentGenerator.documents;

import com.softserve.edu.documentGenerator.utils.Template;
import com.softserve.edu.entity.*;
import com.softserve.edu.entity.user.StateVerificatorEmployee;
import com.softserve.edu.entity.util.DeviceType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.transaction.NotSupportedException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.softserve.edu.entity.util.DeviceType.*;

/**
 * Represents a base document.
 * All real documents extend from this class.
 */
public abstract class BaseDocument {
    /**
     * Verification that is used for getting information for this document.
     */
    private Verification verification;
    /**
     *
     */
    private CalibrationTest calibrationTest;
    /**
     * Template file to be used for writing this document.
     */
    private Template template;

    /**
     * Constructor.
     *
     * @param template     template file to be used for writing this document.
     * @param verification entity to get document's data from.
     */
    public BaseDocument(Template template, Verification verification, CalibrationTest calibrationTest) {
        setTemplate(template);
        setVerification(verification);
        setCalibrationTest(calibrationTest);
    }

    /**
     * @param verification that is used for getting info for this document.
     */
    private void setVerification(Verification verification) {
        this.verification = verification;
    }

    /**
     * @return the template file that is used for this document.
     */
    public Template getTemplate() {
        return template;
    }

    /**
     * @param template file that is used for this document.
     */
    private void setTemplate(Template template) {
        this.template = template;
    }

    /**
     * @return the verification that is used as source of info for this document.
     */
    protected Verification getVerification() {
        return verification;
    }

    public CalibrationTest getCalibrationTest() {
        return calibrationTest;
    }

    protected void setCalibrationTest(CalibrationTest calibrationTest) {
        this.calibrationTest = calibrationTest;
    }

    // Following getters and setters are for verification data that is received from verification entity.

    /**
     * @return the calibrator company's name.
     */
    public String getCalibratorCompanyName() {
        return getVerification().getCalibrator().getName();
    }

    /**
     * @return the state verificator company's name.
     */
    public String getStateVerificatorCompanyName() {
        return getVerification().getStateVerificator().getName();
    }

    /**
     * @return the calibrator's address.
     */
    public String getCalibratorCompanyAddress() {
        Address address = getVerification().getCalibrator().getAddress();

        String addresToReturn = address.getIndex() + ", " +
                address.getLocality() + ", " +
                address.getStreet() + ", " +
                address.getBuilding();

        return addresToReturn;
    }

    /**
     * @return the calibrator company's certificate identification number.
     */
    public String getCalibratorCompanyAccreditationCertificateNumber() {
        return getVerification().getCalibrator().getCertificateNumber();
    }

    /**
     * @return the date when the calibrator company received the certificate, that allows
     * it to.
     */
    public String getCalibratorCompanyAccreditationCertificateGrantedDate() {
        Date certificateGrantedDate = getVerification().getCalibrator().getCertificateGrantedDate();
        String dateFormated = new SimpleDateFormat("yyyy-MM-dd").format(certificateGrantedDate);
        return dateFormated;
    }

    /**
     * @return Returns the identification number of the accreditation certificate,
     * that the calibrator's company owns.
     */
    public String getVerificationCertificateNumber() {
        return String.valueOf(getVerification().getId());
    }

    /**
     * @return the device's name
     */
    public String getDeviceName() {
        String deviceName = "Лічильник ";

        DeviceType deviceType = getVerification().getDevice().getDeviceType();

        switch (deviceType) {
            case ELECTRICAL:
                deviceName += "електрики";
                break;
            case GASEOUS:
                deviceName += "газу";
                break;
            case THERMAL:
                deviceName += "тепла";
                break;
            case WATER:
                deviceName += "води";
                break;
            default:
                throw new IllegalStateException("unsupported device type");
        }

        return  deviceName;
    }

    /**
     * @return the device's sign
     */
    public String getDeviceSign() {
        return getVerification().getDevice().getDeviceSign();
    }

    /**
     * @return the device's manufacturer serial number
     */
    public String getDeviceManufacturerSerial() {
        return String.valueOf(getVerification().getDevice().getId());
    }

    /**
     * @return the device's manufacturer name
     */
    public String getManufacturerName() {
        return getVerification().getDevice().getManufacturer().getName();
    }

    /**
     * @return the owner's full name - surName + name + middleName
     */
    public String getOwnerFullName() {
        ClientData ownerData = getVerification().getClientData();

        String fullName = ownerData.getLastName() + " " +
                ownerData.getFirstName() + " " +
                ownerData.getMiddleName();

        return fullName;
    }

    /**
     * @return the state verificator's name in Surname N.M., where N - first letter of name,
     * M - first letter of middle name.
     */
    public String getStateVerificatorShortName() {
        StateVerificatorEmployee stateVerificatorEmployee = getVerification().getStateVerificatorEmployee();

        String fullName = stateVerificatorEmployee.getLastName() + " "
                + stateVerificatorEmployee.getFirstName();

        return fullName;
    }
}
