package documentGenerationTests;

import com.softserve.edu.documentGenerator.DocumentGenerator;
import com.softserve.edu.documentGenerator.generator.documents.Document;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import org.junit.Test;

import java.io.File;

public class GenerateFileTest {
    @Test
    public void generatePdfTest() {
        Document doc = TestObject.get();

        File generatedDoc =
                DocumentGenerator.generate(doc, DocumentFormat.PDF);

        assert generatedDoc != null;
    }

}
