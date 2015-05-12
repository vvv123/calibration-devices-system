package documentGenerationTests;

import com.softserve.edu.documentGenerator.DocumentGenerator;
import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import org.junit.Test;

import java.io.File;

public class GenerateFileTest {
    @Test
    public void generatePdfTest() {
        BaseDocument doc = TestObject.get();

        File generatedDoc =
                DocumentGenerator.generate(doc, DocumentFormat.PDF);

        assert generatedDoc != null;
    }

}
