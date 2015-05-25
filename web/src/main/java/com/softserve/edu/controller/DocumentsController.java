package com.softserve.edu.controller;

import com.softserve.edu.documents.options.DocumentFormat;
import com.softserve.edu.documents.options.DocumentType;
import com.softserve.edu.entity.user.SystemAdmin;
import com.softserve.edu.service.DocumentsService;
import org.apache.commons.io.FileUtils;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Controller for file generation requests.
 * Generates a requested file and sends it to the caller, in case of an error
 * returns one of the http statuses that signals an error.
 * All exceptions are handled by the @ExceptionHandler methods.
 */
@RestController
@RequestMapping(value = "/doc") // TODO: add security support
public class DocumentsController {

    @Autowired
    DocumentsService documentsService;

    /**
     * Returns a document with a specific format using verification and one of it's tests.
     * For example: .../verification_certificate/1/1/pdf.
     *
     * @param documentType document to generate
     * @param verificationCode id of the verification, for which the document is to be generated
     * @param testID one of the verification's tests, for which the document is to be generated
     * @param format format of the resulting document
     * @return the generated document
     * @throws IOException if file can't be generated because of a file system error
     * @throws IllegalStateException if one of parameters is incorrect
     */
    @RequestMapping(value = "{documentType}/{verificationCode}/{testID}/{format}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDocument(@PathVariable DocumentType documentType,
                                              @PathVariable String verificationCode,
                                              @PathVariable Long testID,
                                              @PathVariable DocumentFormat format)
            throws IOException, IllegalStateException {
        // check input parameters
        InputStream outputStream = documentsService.getFile(verificationCode, testID, documentType, format);

        byte[] bytes = IOUtils.toByteArray(outputStream);
        outputStream.close();

        FileOutputStream out = new FileOutputStream("the.docx");
        out.write(bytes);
        out.close();

        ResponseEntity<byte[]> responseEntity = makeResponse(bytes, HttpStatus.OK, format);

        return responseEntity;
    }

    /**
     * Returns a document with a specific format using verification that has only one test.
     * For example: .../verification_certificate/1/pdf.
     *
     * @param documentType document to generate
     * @param verificationCode id of the verification, for which the document is to be generated. This verification
     *                       must have only one test
     * @param format format of the resulting document
     * @return the generated document
     * @throws IOException if file can't be generated because of a file system error
     * @throws IllegalStateException if one of parameters is incorrect
     */
    @RequestMapping(value = "{documentType}/{verificationCode}/{format}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDocument(@PathVariable DocumentType documentType,
                                              @PathVariable String verificationCode,
                                              @PathVariable DocumentFormat format)
            throws IOException, IllegalStateException {
        InputStream outputStream = documentsService.getFile(verificationCode, documentType, format);

        return makeResponse(IOUtils.toByteArray(outputStream), HttpStatus.OK, format);
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
    @ExceptionHandler(IOException.class)
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
//        headers.setContentDispositionFormData("attachment", filename);
//        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//        headers.add("Content-Type", "application/docx; charset=utf-8");
        headers.add("Content-Transfer-Encoding ", "");

        return new ResponseEntity<>(responseParameter, headers, httpStatus);
    }
}
