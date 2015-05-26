package com.softserve.edu.documents;

import com.softserve.edu.documents.document.Document;
import com.softserve.edu.documents.document.UnfitnessCertificate;
import com.softserve.edu.documents.document.VerificationCertificate;
import com.softserve.edu.documents.parameter.DocumentType;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;
import org.springframework.util.Assert;

public class DocumentFactory {
    /**
     * Creates and returns a document. Document type is determined by documentType's type.
     *
     * @param documentType    by which te type of the document is determined
     * @param verification    verification for this document
     * @param calibrationTest calibration test for this document
     * @return created document
     */
    public static Document build(DocumentType documentType, Verification verification,
                               CalibrationTest calibrationTest) {
        Assert.notNull(verification, verification.getClass() + " can't be null");
        Assert.notNull(calibrationTest, calibrationTest.getClass() + " can't be null");

        Document document;

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
