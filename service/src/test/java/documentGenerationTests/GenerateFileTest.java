package documentGenerationTests;

import com.softserve.edu.documentGenerator.DocumentGenerator;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.Template;
import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Verification;
import org.junit.Test;

import java.io.File;

public class GenerateFileTest {

    @Test
    public void generatePdfTest() {
        int verificationID = 1;

        File generatedDoc =
                DocumentGenerator.generate(Template.DEVICE_CHECK, verificationID, DocumentFormat.PDF);

        assert generatedDoc != null;
    }

}
