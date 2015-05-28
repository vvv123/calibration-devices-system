package com.softserve.edu.controller.provider.util;

import com.softserve.edu.entity.Calibrator;

import java.util.ArrayList;
import java.util.List;

public class VerificationIdAndCalibrationDataDTO {
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
    public List<String> removeAllNullValuesInList(List<String>list){
        List<String>newList = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if (list.get(i)!=null){
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}
