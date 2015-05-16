package com.softserve.edu.document.generator.documents;

import com.softserve.edu.document.generator.utils.Template;
import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.Verification;

/**
 * Represents a device verification protocol.
 */
public class DeviceVerificationProtocol extends BaseDocument {
    public DeviceVerificationProtocol(Verification verification, CalibrationTest calibrationTest) {
        super(Template.VERIFICATION_PROTOCOL, verification, calibrationTest);
    }
}
