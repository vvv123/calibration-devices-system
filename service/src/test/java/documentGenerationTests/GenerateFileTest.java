package documentGenerationTests;

import com.softserve.edu.documentGenerator.DocumentGenerator;
import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.converter.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.Template;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.when;

public class GenerateFileTest {
    @Test
    public void generatePdfTest() {
        VerificationCertificate ver = Mockito.mock(VerificationCertificate.class);

        when(ver.getCalibratorAddress()).thenReturn("02042, м. Львів, вул. Чигоріна, 18");
        when(ver.getCalibratorCertificateGranted()).thenReturn(new Date());
        when(ver.getCalibratorCertificateNumber()).thenReturn("10101");
        when(ver.getCalibratorCompanyName()).thenReturn("СГУО УЕГГ м. Львова");
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR, 2);
        when(ver.getDocumentDate()).thenReturn(instance.getTime());
        when(ver.getDocumentNumber()).thenReturn("3914922");
        when(ver.getManufacturer()).thenReturn("Metrix");
        when(ver.getName()).thenReturn("Олег");
        when(ver.getSerialNumber()).thenReturn("017905");
        when(ver.getSurname()).thenReturn("Чернигевич");
        when(ver.getVerificationLaboratory()).thenReturn("Львівстандартметрологія");
        when(ver.getTemplate()).thenReturn(Template.VERIFICATION_CERTIFICATE);
        when(ver.getAdditionalInfoPageNumber()).thenReturn(1);
        when(ver.getDocumentId()).thenReturn("ДСТУ 2681-94 Державна система забезпечення єдності вимірювань." +
                " Метрологія.");
        when(ver.getSpecificationDocumentName()).thenReturn("");
        when(ver.getDeviceName()).thenReturn("1ПГ-41ГК");

        File generatedDoc =
                DocumentGenerator.generate(ver, DocumentFormat.PDF);

        assert generatedDoc != null;
    }

}
