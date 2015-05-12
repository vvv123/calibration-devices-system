package documentGenerationTests;

import com.softserve.edu.documentGenerator.DocumentGenerator;
import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.converter.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.Template;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.Date;

public class GenerateFileTest {
    @Test
    public void generatePdfTest() {
        VerificationCertificate ver = Mockito.mock(VerificationCertificate.class);

        Mockito.when(ver.getCalibratorAddress()).thenReturn("02042, м. Львів, вул. Чигоріна, 18");
        Mockito.when(ver.getCalibratorCertificateGranted()).thenReturn(new Date());
        Mockito.when(ver.getCalibratorCertificateNumber()).thenReturn("10101");
        Mockito.when(ver.getCalibratorCompanyName()).thenReturn("СГУО УЕГГ м. Львова");
        Mockito.when(ver.getDocumentDate()).thenReturn(new Date());
        Mockito.when(ver.getDocumentNumber()).thenReturn("3914922");
        Mockito.when(ver.getManufacturer()).thenReturn("Metrix");
        Mockito.when(ver.getName()).thenReturn("Олег");
        Mockito.when(ver.getSerialNumber()).thenReturn("017905");
        Mockito.when(ver.getSurname()).thenReturn("Чернигевич");
        Mockito.when(ver.getVerificationLaboratory()).thenReturn("Львівстандартметрологія");
        Mockito.when(ver.getTemplate()).thenReturn(Template.VERIFICATION_CERTIFICATE);
        Mockito.when(ver.getAdditionalInfoPageNumber()).thenReturn(1);
        Mockito.when(ver.getDocumentId()).thenReturn("ДСТУ 2681-94 Державна система забезпечення єдності вимірювань." +
                " Метрологія. Терміни та визначення.");
        Mockito.when(ver.getSpecificationDocumentName()).thenReturn("");

        File generatedDoc =
                DocumentGenerator.generate(ver, DocumentFormat.PDF);

        assert generatedDoc != null;
    }

}
