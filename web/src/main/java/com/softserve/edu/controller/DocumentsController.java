package com.softserve.edu.controller;

import com.softserve.edu.documentGenerator.DocumentGenerator;
import com.softserve.edu.documentGenerator.converter.DocumentFormat;
import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.utils.Template;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.user.Employee;
import com.softserve.edu.service.CalibrationTestService;
import com.softserve.edu.service.VerificationService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.NullType;
import java.beans.PropertyEditorSupport;
import java.io.*;

import static com.softserve.edu.documentGenerator.utils.Template.VERIFICATION_CERTIFICATE;

@RestController
@RequestMapping(value = "/document") // TODO: insert correct value, also security
public class DocumentsController {

    @Autowired
    VerificationService verificationService;

    @Autowired
    CalibrationTestService calibrationTestService;

    /**
     *
     * @param document_type
     * @param verificationID
     * @param testID
     * @param format
     * @return
     * @throws IOException
     */
    // TODO fix document_type
    @RequestMapping(value = "{document_type}/{verificationID}/{testID}/{format}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDocument(@PathVariable Template document_type,
                                              @PathVariable Long verificationID,
                                              @PathVariable Long testID,
                                              @PathVariable DocumentFormat format) throws IOException {
        // check input parameters
        Verification verification = verificationService.findVerification(verificationID);
        Assert.notNull(verification, "can't find a " + verification.getClass() + " with id " + verificationID);

        CalibrationTest calibrationTest = calibrationTestService.findTest(testID);
        Assert.notNull(calibrationTest, "can't find a " + calibrationTest.getClass() + " with id" + testID);

        Assert.state(calibrationTest.getVerification().equals(verification),
                calibrationTest.getClass() + " with id:" + calibrationTest.getId() + " is not assigned to " +
                        verification.getClass() + " with id: " + verification.getId());
        // TODO: fix exception output, delete word class

        // get document
        BaseDocument document = createDocumentByTemplate(document_type, verification, calibrationTest);

        File documentFile = DocumentGenerator.generate(document, format);

        byte[] fileBytes = getFileBytes(documentFile);

        return makeResponse(fileBytes);
    }

    @RequestMapping(value = "{document_type}/{verificationID}/{format}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDocument(@PathVariable Template document_type,
                                              @PathVariable Long verificationID,
                                              @PathVariable DocumentFormat format) throws IOException {
        // check input parameters
        Verification verification = verificationService.findVerification(verificationID);
        Assert.notNull(verification, "can't find verification with id " + verificationID);

        Assert.state(verification.getCalibrationTests().size() != 0,
                verification.getClass() + " with id " + verificationID + " doesn't have any tests assigned to it");
        Assert.state(verification.getCalibrationTests().size() == 1,
                verification.getClass() + " with id " + verificationID + " have more than one test assigned to it. " +
                        "Specify the id of a concrete test");

        // get document
        CalibrationTest calibrationTest = verification.getCalibrationTests().iterator().next();

        BaseDocument document = createDocumentByTemplate(document_type, verification, calibrationTest);

        File documentFile = DocumentGenerator.generate(document, format);

        byte[] fileBytes = getFileBytes(documentFile);

        return makeResponse(fileBytes);
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // register custom editor for the DocumentFormat enum
        dataBinder.registerCustomEditor(DocumentFormat.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                String capitalize = text.toUpperCase();
                DocumentFormat documentFormat = DocumentFormat.valueOf(capitalize);
                setValue(documentFormat);
            }
        });

        // register custom editor for the Template enum
        dataBinder.registerCustomEditor(Template.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                String capitalize = text.toUpperCase();
                Template template = Template.valueOf(capitalize);
                setValue(template);
            }
        });
    }

    /**
     * In case of a illegal state of a path parameter logs exception and
     * sends http status NOT_FOUND to the client
     *
     * @param exception thrown exception
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalStateException.class)
    public void illegalStateExceptionHandler(IllegalStateException exception) {
        exception.printStackTrace(); // TODO add logger
    }

    /**
     * In case of an uncaught exception logs exception and
     * sends http status INTERNAL_SERVER_ERROR to the client
     *
     * @param exception thrown exception
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void uncaughtExceptionHandler(Exception exception) {
        exception.printStackTrace();
    }

    /**
     * Creates and returns a document. Document type is determined by template type.
     *
     * @param template by which te type of the document is determined
     * @param verification verification for this document
     * @param calibrationTest calibration test for this document
     * @return created document
     */
    private BaseDocument createDocumentByTemplate(Template template, Verification verification,
                                                  CalibrationTest calibrationTest) {
        // TODO add asserts
        BaseDocument document = null;

        // TODO: template is redundant
        switch (template) {
            case VERIFICATION_CERTIFICATE:
                document = new VerificationCertificate(template, verification, calibrationTest);
                break;
            case UNFITNESS_CERTIFICATE:
                document = new VerificationCertificate(template, verification, calibrationTest);
                break;
            default:
                throw new IllegalArgumentException(template.name() + "is not supported");
        }

        return document;
    }

    /**
     * Returns the file's byte array
     *
     * @param document
     * @return
     * @throws IOException
     */
    private byte[] getFileBytes(File document) throws IOException {
        // TODO add asserts
        byte[] fileByteArray = null;

        try (InputStream reportInputStream = new FileInputStream(document)) {
            fileByteArray = IOUtils.toByteArray(reportInputStream);
        }

        return fileByteArray;
    }

    private <T> ResponseEntity<T> makeResponse(T responseParameter) {
        // TODO add asserts
        // make response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        //String filename = "output.pdf";
        //headers.setContentDispositionFormData(filename, filename);
        //headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<T>(responseParameter, headers, HttpStatus.OK);
    }
}
