package com.softserve.edu.controller;

import com.softserve.edu.documentGenerator.DocumentFileFactory;
import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.documents.UnfitnessCertificate;
import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.DocumentType;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;
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

import java.beans.PropertyEditorSupport;
import java.io.*;

/**
 * Controller for file generation requests.
 * Generates a requested file and sends it to the caller, in case of an error
 * returns one of the http statuses that signals an error.
 * All exceptions are handled by the @ExceptionHandler methods.
 */
@RestController
@RequestMapping(value = "/document") // TODO: add security support
public class DocumentsController {

    @Autowired
    VerificationService verificationService;

    @Autowired
    CalibrationTestService calibrationTestService;

    /**
     * Returns a document with a specific format using verification and one of it's tests.
     * For example: .../verification_certificate/1/1/pdf.
     *
     * @param documentType document to generate
     * @param verificationID id of the verification, for which the document is to be generated
     * @param testID one of the verification's tests, for which the document is to be generated
     * @param format format of the resulting document
     * @return the generated document
     * @throws IOException if file can't be generated because of a file system error
     * @throws IllegalStateException if one of parameters is incorrect
     */
    @RequestMapping(value = "{documentType}/{verificationID}/{testID}/{format}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDocument(@PathVariable DocumentType documentType,
                                              @PathVariable Long verificationID,
                                              @PathVariable Long testID,
                                              @PathVariable DocumentFormat format)
            throws IOException, IllegalStateException {
        // check input parameters
        Verification verification = verificationService.findVerification(verificationID);
        Assert.notNull(verification, "can't find a " + verification.getClass() + " with id " + verificationID);

        CalibrationTest calibrationTest = calibrationTestService.findTest(testID);
        Assert.notNull(calibrationTest, "can't find a " + calibrationTest.getClass() + " with id" + testID);

        Assert.state(calibrationTest.getVerification().equals(verification),
                calibrationTest.getClass() + " with id:" + calibrationTest.getId() + " is not assigned to " +
                        verification.getClass() + " with id: " + verification.getId());

        // get document
        BaseDocument document = createDocumentByTemplate(documentType, verification, calibrationTest);

        ByteArrayOutputStream documentFile = DocumentFileFactory.build(document, format);

        return makeResponse(documentFile.toByteArray(), HttpStatus.OK, format);
    }

    /**
     * Returns a document with a specific format using verification that has only one test.
     * For example: .../verification_certificate/1/pdf.
     *
     * @param documentType document to generate
     * @param verificationID id of the verification, for which the document is to be generated. This verification
     *                       must have only one test
     * @param format format of the resulting document
     * @return the generated document
     * @throws IOException if file can't be generated because of a file system error
     * @throws IllegalStateException if one of parameters is incorrect
     */
    @RequestMapping(value = "{documentType}/{verificationID}/{format}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDocument(@PathVariable DocumentType documentType,
                                              @PathVariable Long verificationID,
                                              @PathVariable DocumentFormat format)
            throws IOException, IllegalStateException {
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

        BaseDocument document = createDocumentByTemplate(documentType, verification, calibrationTest);

        ByteArrayOutputStream documentFile = DocumentFileFactory.build(document, format);

        return makeResponse(documentFile.toByteArray(), HttpStatus.OK, format);
    }

    /**
     * In case of a illegal state of a path parameter logs exception and
     * sends http status NOT_FOUND to the client.
     *
     * @param exception thrown exception
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public void illegalStateExceptionHandler(IllegalStateException exception) {
        exception.printStackTrace(); // TODO add logger
    }

    /**
     * In case of an file system logs exception and
     * sends http status NOT_FOUND to the client.
     *
     * @param exception thrown exception
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalStateException.class)
    public void ioExceptionHandler(IOException exception) {
        exception.printStackTrace();
    }

    /**
     * In case of an uncaught exception logs exception and
     * sends http status INTERNAL_SERVER_ERROR to the client.
     *
     * @param exception thrown exception
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void uncaughtExceptionHandler(Exception exception) {
        exception.printStackTrace();
    }

    /**
     * {inherit}
     */
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

        // register custom editor for the DocumentType enum
        dataBinder.registerCustomEditor(DocumentType.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                String capitalize = text.toUpperCase();
                DocumentType documentType = DocumentType.valueOf(capitalize);
                setValue(documentType);
            }
        });
    }

    /**
     * Creates a response.
     *
     * @param responseParameter parameter of the response
     * @param httpStatus http status of the respond
     * @param <T> type of the response parameter
     * @return response that is ready to be sent
     */
    private <T> ResponseEntity<T> makeResponse(T responseParameter, HttpStatus httpStatus,
                                               DocumentFormat documentFormat) {
        Assert.notNull(responseParameter, "Response parameter = " + responseParameter + ". " +
                "Response parameter can't be null");
        HttpHeaders headers = new HttpHeaders();

        String filename;

        switch (documentFormat) {
            case PDF:
                headers.setContentType(MediaType.parseMediaType("application/pdf"));
                filename = "output.pdf";
                break;
            case DOCX:
                headers.setContentType(MediaType.parseMediaType("application/docx"));
                filename = "output.docx";
                break;
            default:
                throw new IllegalArgumentException(documentFormat.name() + "is not supported");
        }
        headers.setContentDispositionFormData(filename, filename);
        //headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(responseParameter, headers, httpStatus);
    }

    /**
     * Creates and returns a document. Document type is determined by documentType's type.
     *
     * @param documentType by which te type of the document is determined
     * @param verification verification for this document
     * @param calibrationTest calibration test for this document
     * @return created document
     */
    private BaseDocument createDocumentByTemplate(DocumentType documentType, Verification verification,
                                                  CalibrationTest calibrationTest) {
        Assert.notNull(verification, verification.getClass() + " can't be null");
        Assert.notNull(calibrationTest, calibrationTest.getClass() + " can't be null");

        BaseDocument document;

        // TODO: documentType is redundant
        switch (documentType) {
            case VERIFICATION_CERTIFICATE:
                document = new VerificationCertificate(verification, calibrationTest);
                break;
            case UNFITNESS_CERTIFICATE:
                document = new UnfitnessCertificate(verification, calibrationTest);
                break;
            default:
                throw new IllegalArgumentException(documentType.name() + "is not supported");
        }

        return document;
    }
}
