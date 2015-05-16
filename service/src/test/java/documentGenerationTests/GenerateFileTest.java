package documentGenerationTests;

import com.softserve.edu.documentGenerator.DocumentGenerator;
import com.softserve.edu.documentGenerator.converter.DocumentFormat;
import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.utils.Template;
import com.softserve.edu.entity.CalibrationTestData;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.service.CalibrationTestDataService;
import com.softserve.edu.service.ClientService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.when;

public class GenerateFileTest {
    @Test
    public void generatePdfTest() {
//        VerificationCertificate verificationMock = Mockito.mock(VerificationCertificate.class);
//
//        when(verificationMock.getCalibratorCompanyName()).thenReturn("СГУО УЕГГ м. Львова");
//        when(verificationMock.getTemplate()).thenReturn(Template.VERIFICATION_CERTIFICATE);
//        when(verificationMock.getStateVerificatorCompanyName()).thenReturn(Template.VERIFICATION_CERTIFICATE);
//        when(verificationMock.getDeviceManufacturerSerial()).thenReturn(Template.VERIFICATION_CERTIFICATE);
//        when(verificationMock.getStateVerificatorCompanyName()).thenReturn(Template.VERIFICATION_CERTIFICATE);
//
//        /////////////////////////////
//
//        when(verificationMock.getAdditionalInfoPageNumber()).thenReturn(1);
//        when(verificationMock.getDocumentId()).thenReturn("ДСТУ 2681-94 Державна система забезпечення єдності вимірювань." +
//                " Метрологія.");
//        when(verificationMock.getSpecificationDocumentName()).thenReturn("");
//
//        // mock calibrator
//        when(verificationMock.getCalibratorCompanyAddress()).thenReturn("02042, м. Львів, вул. Чигоріна, 18");
//        when(verificationMock.get()).thenReturn(new Date());
//        when(verificationMock.getCalibratorCertificateNumber()).thenReturn("10101");
//
//        // mock document
//        Calendar instance = Calendar.getInstance();
//        instance.add(Calendar.YEAR, 2);
//        when(verificationMock.getDocumentDate()).thenReturn(instance.getTime());
//        when(verificationMock.getDocumentNumber()).thenReturn("3914922");
//
//        // mock device
//        when(verificationMock.getManufacturer()).thenReturn("Metrix");
//        when(verificationMock.getSerialNumber()).thenReturn("017905");
//        when(verificationMock.getDeviceName()).thenReturn("1ПГ-41ГК");
//
//        // mock owner
//        when(verificationMock.getName()).thenReturn("Олег");
//        when(verificationMock.getSurname()).thenReturn("Чернигевич");
//
//        // mock verification laboratory
//        when(verificationMock.getVerificationLaboratory()).thenReturn("Львівстандартметрологія");
//
//        // mock additional info
//
//        File generatedDoc =
//                DocumentGenerator.generate(verificationMock, DocumentFormat.PDF);
//
//        Assert.assertNotNull(generatedDoc);


    }

}
