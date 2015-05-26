package com.softserve.edu.controller.provider.util;

import com.softserve.edu.entity.Calibrator;

import java.util.List;

/**
 * Created by Oles Onyshchak on 5/25/2015.
 */
public class VerificationsAndCalibrationIdsDTO {
    private List<String> verificationIds;
   private Calibrator calibrator;

    public List<String> getVerificationIds() {
        return verificationIds;
    }

    public void setVerificationIds(List<String> verificationIds) {
        this.verificationIds = verificationIds;
    }

    public Calibrator getCalibrator() {
        return calibrator;
    }

    public void setCalibrator(Calibrator calibrator) {
        this.calibrator = calibrator;
    }
}
