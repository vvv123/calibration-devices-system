package com.softserve.edu.document.generator.documents;

import com.softserve.edu.document.generator.utils.Template;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.user.StateVerificatorEmployee;
import com.softserve.edu.entity.util.DeviceType;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    /*public String getCalibratorCompanyAddress() {
        return getVerification().getCalibrator().getAddress().toString();
    }*/

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
    public String getOwnerNameFull() {
        ClientData ownerData = getVerification().getClientData();

        String fullName = ownerData.getLastName() + " " +
                ownerData.getFirstName() + " " +
                ownerData.getMiddleName();

        return fullName;
    }

    /**
     * @return get the sign of the document, which contains the metrological characteristics
     */
    public String getMetrologicalDocumentSign() {
        return getCalibrationTest().getMetrologicalDocument().getSign();
    }

    /**
     * @return get the name of the document, which contains the metrological characteristics
     */
    public String getMetrologicalDocumentName() {
        return getCalibrationTest().getMetrologicalDocument().getName();
    }

    /**
     * @return the state verificator's name
     */
    public String getStateVerificatorName() {
        StateVerificatorEmployee stateVerificatorEmployee = getVerification().getStateVerificatorEmployee();

        String fullName = stateVerificatorEmployee.getLastName() + " "
                + stateVerificatorEmployee.getFirstName();

        return fullName;
    }
}
