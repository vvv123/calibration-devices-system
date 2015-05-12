package documentGenerationTests;

import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.documents.documentsFields.*;
import com.softserve.edu.documentGenerator.utils.Template;

import java.util.Date;

public class TestObject {
    public static VerificationCertificate get() {
        Device deviceMock = TestObject.getDeviceMock();
        VerificationCertificateData dataMock = TestObject.getVerificationCertificateDataMock();
        Calibrator calibratorMock = TestObject.getCalibrator();
        DocumentData documentData = TestObject.getDocumentData();
        Laboratory laboratory = TestObject.getLaboratory();
        Person employeeMock = TestObject.getEmployeeMock();

        VerificationCertificate mock = new VerificationCertificate();
        mock.setDevice(deviceMock);
        mock.setVerificationCertificateData(dataMock);
        mock.setCalibrator(calibratorMock);
        mock.setDocumentData(documentData);
        mock.setLaboratory(laboratory);
        mock.setOwner(employeeMock);
        mock.setVerificationID(5893L);
        mock.setTemplate(Template.VERIFICATION_CERTIFICATE);

        return mock;
    }

    public static Device getDeviceMock() {
        Device device = new Device();

        device.setDeviceConditionalSign("12");
        device.setDeviceName("");
        device.setManufacturer("Оріон");
        device.setSerialNumber(1234567890);

        return device;
    }

    public static VerificationCertificateData getVerificationCertificateDataMock() {
        VerificationCertificateData data = new VerificationCertificateData();

        data.setAdditionalInfoPageNumber(2);
        data.setDocumentId("док.лв.1222");
        data.setSpecificationDocumentName("документ стандартизації");

        return data;
    }

    public static Person getEmployeeMock() {
        Person p = new Person();

        p.setName("Олег");
        p.setSurname("Чернигевич");
        p.setMiddleName("Ігорович");

        return p;
    }

    public static Calibrator getCalibrator() {
        Calibrator data = new Calibrator();

        data.setCalibratorAddress("");
        data.setCalibratorCertificateGranted(new Date());
        data.setCalibratorCertificateNumber(756304);
        data.setCalibratorCompanyName("Омега");
        data.setCalibratorEmployee(getEmployeeMock());

        return data;
    }

    public static DocumentData getDocumentData() {
        DocumentData data = new DocumentData();

        data.setDocumentDate(new Date(123123));
        data.setDocumentNumber(123123);

        return data;
    }

    public static Laboratory getLaboratory() {
        Laboratory data = new Laboratory();

        data.setVerificationLaboratory("Львівська лабораторія");
        data.setVerificationLaboratoryHead(getEmployeeMock());

        return data;
    }
}
