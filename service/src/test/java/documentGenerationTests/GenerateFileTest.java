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

        Mockito.when(ver.getCalibratorAddress()).thenReturn("Львів, вул Шевченка, 80");
        Mockito.when(ver.getCalibratorCertificateGranted()).thenReturn(new Date(123L));
        Mockito.when(ver.getCalibratorCertificateNumber()).thenReturn("538583");
        Mockito.when(ver.getCalibratorCompanyName()).thenReturn("538583");
        Mockito.when(ver.getDocumentDate()).thenReturn(new Date());
        Mockito.when(ver.getDocumentNumber()).thenReturn("531");
        Mockito.when(ver.getManufacturer()).thenReturn("Оріон");
        Mockito.when(ver.getName()).thenReturn("Олег");
        Mockito.when(ver.getSerialNumber()).thenReturn("573857");
        Mockito.when(ver.getSurname()).thenReturn("Чернигевич");
        Mockito.when(ver.getVerificationLaboratory()).thenReturn("Львівська лабораторія");
        Mockito.when(ver.getTemplate()).thenReturn(Template.VERIFICATION_CERTIFICATE);
        Mockito.when(ver.getAdditionalInfoPageNumber()).thenReturn(1);
        Mockito.when(ver.getDocumentId()).thenReturn("asd");
        Mockito.when(ver.getSpecificationDocumentName()).thenReturn("asd");

        File generatedDoc =
                DocumentGenerator.generate(ver, DocumentFormat.PDF);

        assert generatedDoc != null;
    }

}
