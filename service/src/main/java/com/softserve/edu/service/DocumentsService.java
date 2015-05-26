package com.softserve.edu.service;

import com.softserve.edu.documents.DocumentFactory;
import com.softserve.edu.documents.FileFactory;
import com.softserve.edu.documents.document.Document;
import com.softserve.edu.documents.parameter.DocumentFormat;
import com.softserve.edu.documents.parameter.DocumentType;
import com.softserve.edu.documents.parameter.FileParameters;
import com.softserve.edu.documents.parameter.FileSystem;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.repository.CalibrationTestRepository;
import com.softserve.edu.repository.VerificationRepository;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.InputStream;
import java.util.Set;

@Service
@Transactional
public class DocumentsService {

    @Autowired
    VerificationRepository verificationRepository;

    @Autowired
    CalibrationTestRepository calibrationTestRepository;

    public InputStream getFile(String verificationCode, DocumentType documentType, DocumentFormat documentFormat) {
        Verification verification = verificationRepository.findOne(verificationCode);

        // check input parameters
        Assert.notNull(verification, "can't find verification with id " + verificationCode);

        Set<CalibrationTest> calibrationTests = verification.getCalibrationTests();

        Assert.state(calibrationTests.size() != 0,
                verification.getClass() + " with id " + verificationCode + " doesn't have any tests assigned to it");

        Assert.state(calibrationTests.size() == 1,
                verification.getClass() + " with id " + verificationCode + " have more than one test assigned to it. " +
                        "Specify the id of a concrete test");

        CalibrationTest calibrationTest = verification.getCalibrationTests().iterator().next();

        return builFile(documentType, verification, calibrationTest, documentFormat);
    }

    public InputStream getFile(String verificationCode, Long calibrationTestID,
                                         DocumentType documentType, DocumentFormat documentFormat) {
        Verification verification = verificationRepository.findOne(verificationCode);
        CalibrationTest calibrationTest = calibrationTestRepository.findOne(calibrationTestID);

        // check input parameters
        Assert.notNull(verification, "can't find a " + verification.getClass() + " with id " + verificationCode);

        Assert.notNull(calibrationTest, "can't find a " + calibrationTest.getClass() + " with id" + calibrationTestID);

        Assert.state(calibrationTest.getVerification().equals(verification),
                calibrationTest.getClass() + " with id:" + calibrationTest.getId() + " is not assigned to " +
                        verification.getClass() + " with id: " + verification.getId());

        return builFile(documentType, verification, calibrationTest, documentFormat);
    }

    private InputStream builFile(DocumentType documentType, Verification verification,
                                           CalibrationTest calibrationTest, DocumentFormat documentFormat) {
        Document document = DocumentFactory.build(documentType, verification, calibrationTest);

        FileParameters fileParameters = new FileParameters(document, documentType, documentFormat);
fileParameters.setFileSystem(FileSystem.RAM);

        try {
            FileObject fileObject = FileFactory.buildFile(fileParameters);
            InputStream inputStream = fileObject.getContent().getInputStream();
            return inputStream;
        } catch (FileSystemException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
