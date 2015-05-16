package com.softserve.edu.controller;

import com.softserve.edu.documentGenerator.DocumentGenerator;
import com.softserve.edu.documentGenerator.converter.DocumentFormat;
import com.softserve.edu.documentGenerator.documents.VerificationCertificate;
import com.softserve.edu.documentGenerator.utils.Template;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.user.Employee;
import com.softserve.edu.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/doc") // TODO: insert correct value
public class DocumentsController {

    @Autowired
    VerificationService verificationService;

    @RequestMapping(value = "/{pageNumber}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDocument(@PathVariable Integer pageNumber) {
        byte[] reportBytes = null;
        try {
            // create file
            final Long verifcationID = 1L; // TODO: replace with real param
            Verification verification = verificationService.findVerification(verifcationID);
            CalibrationTest calibrationTest = verification.getCalibrationTests().iterator().next();

            VerificationCertificate verificationCertificate = new VerificationCertificate(
                    Template.VERIFICATION_CERTIFICATE, verification, calibrationTest
            );

            //File reportFile = new File(propertyMap.get(PRODUCTIVITY_REPORT_FILE));
            File reportFile = DocumentGenerator.generate(verificationCertificate, DocumentFormat.PDF);

            if (reportFile != null && reportFile.exists()) {
                InputStream reportInputStream = new FileInputStream(reportFile);
                long length = reportFile.length();
                reportBytes = new byte[(int) length];
                int offset = 0;
                int numRead = 0;
                while (offset < reportBytes.length
                        && (numRead = reportInputStream.read(reportBytes, offset, reportBytes.length - offset)) >= 0) {
                    offset += numRead;
                }
                if (offset < reportBytes.length) {
                    throw new Exception("Could not completely read file " + reportFile.getName());
                }
                reportInputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "output.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(reportBytes, headers, HttpStatus.OK);

        return response;
    }
}
