package documentGenerationTests;

import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.CalibrationTestData;
import com.softserve.edu.entity.Calibrator;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.user.CalibratorEmployee;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by oleg on 14.05.15.
 */
public class InsertData {

    public static void insert() {

    }

    static Verification verification = new Verification();
    static Set<CalibrationTest> calibrationTests = getTests();
    static Set<CalibrationTestData> calibrationTestDataSets = getTestsDatas();
    static CalibratorEmployee employee = getEmployees();

    public Verification getVerification() {
        Verification verification = new Verification();
        verification.setCalibrationTests(calibrationTests);
        verification.setCalibratorEmployee(employee);

        return verification;
    }

    public static CalibratorEmployee getEmployees() {
        CalibratorEmployee calibratorEmployee = new CalibratorEmployee();
        calibratorEmployee.setEmail("gmail");
        calibratorEmployee.setFirstName("name");
        calibratorEmployee.setLastName("lastname");
        calibratorEmployee.setOrganization(new Calibrator("organization1", "email", "phone"));
        calibratorEmployee.setPassword("pass");
        calibratorEmployee.setPhone("phone");
        calibratorEmployee.setRole("role");
        calibratorEmployee.setUsername("ads");

        return calibratorEmployee;
    }

    public static Set<CalibrationTest> getTests() {
        Set<CalibrationTest> tests = new HashSet<>();

        CalibrationTest calibrationTest1 = new CalibrationTest();
        calibrationTest1.setCalibrationTestDatas(calibrationTestDataSets);
        calibrationTest1.setConsumptionStatus("active");
        calibrationTest1.setDateTest(new Date());
        calibrationTest1.setDeviceNumber("123");
        calibrationTest1.setLatitude(10.0);
        calibrationTest1.setLongitude(10.0);
        calibrationTest1.setName("device");
        calibrationTest1.setPhotoPath("asd");
        calibrationTest1.setSettingNumber(10);
        calibrationTest1.setTemperature(10);
        calibrationTest1.setTestResult("OK");
        calibrationTest1.setVerification(verification);

        return tests;
    }

    public static Set<CalibrationTestData> getTestsDatas() {
        Set<CalibrationTestData> testsDatas = new HashSet<>();

        CalibrationTestData calibrationTestData1 = new CalibrationTestData();
        calibrationTestData1.setAcceptableError(10);
        calibrationTestData1.setActualConsumption(10.0);
        calibrationTestData1.setCalibrationTest(new CalibrationTest());
        calibrationTestData1.setConsumptionStatus(10.0);
        calibrationTestData1.setEndValue(10.0);
        calibrationTestData1.setGivenConsumption(22.0);
        calibrationTestData1.setInitialValue(10.0);
        calibrationTestData1.setTestTime(10.0);
        calibrationTestData1.setVolumeInDevice(22.0);
        calibrationTestData1.setVolumeOfStandart(10);

        return testsDatas;
    }
}
